package com.born2do.crawler.processor;

import com.born2do.crawler.log.ILogger;
import com.born2do.crawler.log.LoggerImpl;
import com.born2do.crawler.pipeline.Ku137PipeLine;
import com.born2do.crawler.util.JsoupUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenhy
 * @date 2021/9/11
 */
@Component
public class Ku137PageProcessor implements PageProcessor {

    private static final ILogger logger = new LoggerImpl(Ku137PageProcessor.class);

    private static final String WEBSITE = "https://www.ku137.net/b/tag/";

    private static final String WEBNAME = "美图吧 - 高清美女写真";

    // 超时时间（ms）
    private static final int timeout = 5000;
    // 重试次数
    private static final int retryTimes = 5;
    // 重试时间间隔（ms）
    private static final int retrySleepTime = 1000;

    private Site site = Site.me().setCharset("GBK")
            .setTimeOut(1000 * 30)
            .setRetrySleepTime(1000 * 5)
            .setRetryTimes(10);
    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    @Override
    public void process(Page page) {
        List<Selectable> nodes = page.getHtml().xpath("//div[@class='m-list ml1']//a").nodes();
        String jiGouTag = page.getHtml().xpath("//div[@class='l-title']/h1/text()").get();
        HashMap<String, Object> map = new HashMap<>();
        for (Selectable album : nodes) {
            // eg: https://www.ku137.net/b/9/42230.html
            String firstPageUrl = album.$("a", "href").toString();
            String albumName = album.$("a", "title").toString();
            List<String> imgUrl = getImgUrl(firstPageUrl);
            map.put(albumName, imgUrl);
        }
        page.putField("WebName", WEBNAME);
        page.putField("jiGou", jiGouTag);
        page.putField("albumDetail", map);
    }

    private List<String> getImgUrl(String firstPageUrl) {
        List<String> imgUrls = new ArrayList<>();
        Document document = JsoupUtil.getDocument(firstPageUrl, timeout, retryTimes, retrySleepTime);
        if (null != document) {
            List<String> picUrl = document.getElementsByClass("content").get(0).getElementsByTag("img").eachAttr("src");
            imgUrls.addAll(picUrl);
            String pageStr = document.getElementsByClass("page").get(0).getElementsByTag("a").get(0).text();
            int pageNum = Integer.parseInt(pageStr.substring(pageStr.lastIndexOf("共") + 1, pageStr.lastIndexOf("页")));
            for (int i = 2; i <= pageNum; i++) {
                // eg: https://www.ku137.net/b/9/42230_2.html
                Document next = JsoupUtil.getDocument(firstPageUrl.substring(0, firstPageUrl.lastIndexOf(".html")) + "_" + i + ".html", timeout, retryTimes, retrySleepTime);
                if (null != next) {
                    List<String> more = next.getElementsByClass("content").get(0).getElementsByTag("img").eachAttr("src");
                    imgUrls.addAll(more);
                }
            }
        }
        return imgUrls;
    }

    /**
     * get the site settings
     *
     * @return site
     * @see Site
     */
    @Override
    public Site getSite() {
        return site;
    }

    // 每周三凌晨1:00开始调度
    @Scheduled(cron = "0 0 1 * * 3")
//    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void excute() {
        Document document = JsoupUtil.getDocument(WEBSITE, timeout, retryTimes, retrySleepTime);
        List<String> urls = new ArrayList<>();
        if (null != document) {
            Elements jiGous = document.getElementsByClass("jigou").get(0).getElementsByTag("a");
            for (Element jiGou : jiGous) {
                // eg: https://www.ku137.net/b/9/
                String tagFirstUrl = jiGou.absUrl("href");
                Document tagFirstPage = JsoupUtil.getDocument(tagFirstUrl, timeout, retryTimes, retrySleepTime);
                if (null != tagFirstPage) {
                    int pageNum = Integer.parseInt(tagFirstPage.getElementsByTag("strong").get(0).text());
                    // eg: https://www.ku137.net/b/9/list_9_1.html
                    for (int i = 1; i <= pageNum; i++) {
                        urls.add(tagFirstUrl + "list_"
                                + tagFirstUrl.substring(0, tagFirstUrl.length()-1).substring(tagFirstUrl.substring(0, tagFirstUrl.length()-1).lastIndexOf("/") + 1)
                                + "_" + i + ".html");
                    }
                }
            }
        }
        logger.info("push to queue：" + urls, "Ku137");
        Spider.create(new Ku137PageProcessor())
                .addUrl(urls.toArray(new String[urls.size()]))
                .addPipeline(new Ku137PipeLine())
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000)))
                .thread(50)
                .run();
    }
}
