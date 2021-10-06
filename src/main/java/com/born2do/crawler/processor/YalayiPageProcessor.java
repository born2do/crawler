package com.born2do.crawler.processor;

import com.born2do.crawler.log.ILogger;
import com.born2do.crawler.log.LoggerImpl;
import com.born2do.crawler.pipeline.YalayiPipeline;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Arrays;
import java.util.List;

/**
 * @author chenhy
 * @date 2021/9/2
 */
@Component
public class YalayiPageProcessor implements PageProcessor {

    private static final ILogger logger = new LoggerImpl(YalayiPageProcessor.class);

    // 官网名称
    private static final String webName = "雅拉伊";
    // 官网地址
    private static final String website = "https://www.yalayi.com/";

    // 最小地址页数
    private static int minPageNumber = 15;
    // 最大地址页数
    private static int maxPageNumber = 1000;

    @Autowired
    private YalayiPipeline yalayiPipeline;

    private Site site = Site.me().setCharset("UTF8") // 编码格式
            .setTimeOut(1000 * 30) // 超时时间
            .setRetrySleepTime(1000 * 5) // 重试时间间隔
            .setRetryTimes(10); // 重试次数

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    @Override
    public void process(Page page) {// 模特名称
        String modelName = page.getHtml().xpath("//div[@class='content']/ul/li[@class='mt']/p/a")
                .nodes().get(1).$("a", "text").toString();
        // 作品名称
        String artName = page.getHtml().xpath("//div[@class='content']/div[@class='jieshao']/h1/text()").toString();
        // 分辨率
        String resolution = page.getHtml().xpath("//div[@class='content']/div[@class='jieshao']/p")
                .nodes().get(1).$("p", "text").toString();
        // 发行日期
        String issues = page.getHtml().xpath("//div[@class='content']/div[@class='jieshao']/p")
                .nodes().get(2).$("p", "text").toString();
        // 作品说明
        String introduction = page.getHtml().xpath("//div[@class='content']/div[@class='jieshao']/p")
                .nodes().get(3).$("p", "text").toString();
        // 作品标签
        String lables = "";
        List<Selectable> labelList = page.getHtml().xpath("//div[@class='content']/div[@class='jieshao']/p")
                .nodes().get(4).$("a").nodes();
        for (Selectable label : labelList) {
            lables = lables + label.$("a", "text").toString() + ",";
        }
        // 图片源地址
        List<Selectable> picUrls = page.getHtml().$("div.main > div.imgs-box > div.bigimg")
                .nodes().get(0).$("img.lazy", "data-original").nodes();

        page.putField("webName", webName);
        page.putField("website", website);
        page.putField("pgaddr", page.getUrl().toString());
        page.putField("modelName", modelName);
        page.putField("artName", artName);
        page.putField("resolution", resolution);
        page.putField("issues", issues);
        page.putField("introduction", introduction);
        page.putField("lables", lables);
        page.putField("picUrls", picUrls);
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

    // 每周一凌晨1:00开始调度
    @Scheduled(cron = "0 0 1 * * 1")
//    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void excute() {
        List<String> urls = new ArrayList<>();
        for (int i = minPageNumber; i <= maxPageNumber; i++) {
            urls.add(website + "/gallery/" + i + ".html");
            logger.info("添加地址：" + website + "/gallery/" + i + ".html", "yalayi");
        }
        System.out.println("详情页地址添加完毕！");
        logger.info("详情页地址添加完毕！", "yalayi");
        Spider.create(new YalayiPageProcessor())
                .addUrl(urls.toArray(new String[urls.size()]))
                .addPipeline(yalayiPipeline)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(1000)))
                .thread(10)
                .run();
        System.out.println("网站图片下载结束");
        logger.info("网站图片下载结束", "yalayi");
    }

}
