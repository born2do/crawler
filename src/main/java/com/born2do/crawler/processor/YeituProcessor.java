package com.born2do.crawler.processor;

import com.born2do.crawler.constant.PathConstant;
import com.born2do.crawler.log.ILogger;
import com.born2do.crawler.log.LoggerImpl;
import com.born2do.crawler.pipeline.YeituPipeLine;
import com.born2do.crawler.util.CompressUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenhy
 * @date 2021/9/6
 */
@Component
public class YeituProcessor implements PageProcessor {

    private static final ILogger logger = new LoggerImpl(YeituProcessor.class);

    // 官网名称
    private static final String webName = "亿图全景图库";
    // 官网地址
    private static final String website = "https://www.yeitu.net/";
    // 图片下载时的请求头参数，用于解决防盗链问题
    private static Map<String, String> requestProperty = new HashMap<>();

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
    public void process(Page page) {
        if (-1 == page.getUrl().toString().indexOf("?&page=")) {
            List<Selectable> pageBtn = page.getHtml().xpath("//div[@id='pages']").$("a").nodes();
            System.out.println("===标签详情页面最大页数：" + pageBtn.get(pageBtn.size()-2).$("a", "text").toString());
            int maxPageNum = Integer.parseInt(pageBtn.get(pageBtn.size()-2).$("a", "text").toString());
            for (int i=1; i<=maxPageNum; i++) {
                page.addTargetRequest(page.getUrl() + "?&page=" + i);
            }
            System.out.println("===当前targetRequest中url数量：" + page.getTargetRequests().toString());
        } else {
            String tag = page.getHtml().$("strong", "text").toString();
            System.out.println("===相册标签：" + tag);
            List<Selectable> links = page.getHtml().xpath("//div[@class='tag_list']").nodes();
            HashMap<String, Object> map = new HashMap<>();
            for (Selectable link : links) {
                // 相册第一页URL
                String albumUrl = link.xpath("//a").nodes().get(1).$("a", "href").toString();
                System.out.println("===相册第一页URL：" + albumUrl);
                // 相册名称
                String albumName = link.xpath("//a").nodes().get(1).$("a", "text").toString();
                System.out.println("===相册名称：" + albumName);
                List<String> imgUrls = null;
                imgUrls = getImgUrl(albumUrl);
                map.put(albumName, imgUrls);
            }
            page.putField("webName", webName);
            page.putField("requestProperty", requestProperty);
            page.putField("tag", tag);
            page.putField("albumDetail", map);
        }



    }

    private List<String> getImgUrl(String firstPageUrl) {
        // 用于存放相册图片的详细地址
        List<String> imgUrls = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect(firstPageUrl).timeout(10000).get();
        } catch (IOException e) {
            if (null == document) {
                for (int i = 0; i < 5; i++) {
                    try {
                        document = Jsoup.connect(firstPageUrl).timeout(20000).get();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    if (null != document) {
                        break;
                    }
                }
            }
        }

        if (null != document) {
            // 相册首页的图片地址
            String picSrc01 = document.getElementsByClass("img_box").get(0)
                    .getElementsByTag("a").get(0)
                    .getElementsByTag("img").get(0)
                    .attr("src");
            imgUrls.add(picSrc01);
            String pageUrlPrefix = firstPageUrl.substring(0, firstPageUrl.lastIndexOf(".html"));
            Elements pageBtn = document.getElementById("pages").getElementsByTag("a");
            int pageNum = Integer.parseInt(pageBtn.get(pageBtn.size() - 2).text());
            for (int i=2; i<=pageNum; i++) {
                Document next = null;
                try {
                    next = Jsoup.connect(pageUrlPrefix + "_" + i + ".html").timeout(10000).get();
                } catch (IOException e) {
                    if (null == next) {
                        for (int j = 0; j < 5; j++) {
                            try {
                                next = Jsoup.connect(firstPageUrl).timeout(20000).get();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                            if (null != next) {
                                break;
                            }
                        }
                    }
                }
                if (null != next) {
                    String picSrc = next.getElementsByClass("img_box").get(0)
                            .getElementsByTag("a").get(0)
                            .getElementsByTag("img").get(0)
                            .attr("src");
                    imgUrls.add(picSrc);
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
    // 每周二凌晨1:00开始调度
    @Scheduled(cron = "0 0 1 * * 2")
//    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void excute() {
        String[] tagUrl = {"https://www.yeitu.net/tag/youguowang/", "https://www.yeitu.net/tag/meiyanshe/",
                "https://www.yeitu.net/tag/toutiaonvshen/", "https://www.yeitu.net/tag/meiyuanguan/",
                "https://www.yeitu.net/tag/tuinvlang/", "https://www.yeitu.net/tag/boluoshe/",
                "https://www.yeitu.net/tag/yunvlang/", "https://www.yeitu.net/tag/tangguohuabao/",
                "https://www.yeitu.net/tag/youxingguan/", "https://www.yeitu.net/tag/qingdouke/",
                "https://www.yeitu.net/tag/mofanxueyuan/", "https://www.yeitu.net/tag/guotuanwang/",
                "https://www.yeitu.net/tag/youmihui/"};
        requestProperty.put("Referer", website);
        Spider.create(new YeituProcessor())
                .addUrl(tagUrl)
                .addPipeline(new YeituPipeLine())
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000)))
                .thread(50)
                .run();
        logger.info("当前网站图片下载全部完成", "yeitu");
        logger.info("开始进行打包操作……", "yeitu");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(PathConstant.DIR + "/" + webName + System.currentTimeMillis() + ".zip"));
            CompressUtil.compressToZip(new File(PathConstant.DIR + "/" + webName), outputStream,true);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("打包完成：" + PathConstant.DIR + "/" + webName + System.currentTimeMillis() + ".zip", "yeitu");
    }
}
