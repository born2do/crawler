package com.born2do.crawler.processor;

import com.born2do.crawler.constant.PathConstant;
import com.born2do.crawler.pipeline.MarkdownPipeLine;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 获取webmagic官方文档
 * @author chenhy
 * @date 2021/8/31
 */
public class WebmagicDocPageProcessor implements PageProcessor {

    private static final String website = "http://webmagic.io/docs/zh/";

    private static final String dir = PathConstant.DIR;

    private static final String fileName = "webmagic.md";

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
        // 获取所有目录的url，并加入爬虫队列中
        if (website.equals(page.getUrl().toString())) {
            List<String> urls = page.getHtml().xpath("//li[@class='chapter']").links().all();
            for (String url : urls) {
                page.addTargetRequest(url);
            }
        }
        // 获取内容
        String content = page.getHtml().xpath("//section").toString();
        page.putField("content", content);
        System.out.println(page.getUrl() + " ===> page download over!");
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

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get(dir + "/" + fileName);
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }
        Files.createFile(filePath);
        Spider.create(new WebmagicDocPageProcessor()).addUrl(website)
                .thread(1)
                .addPipeline(new MarkdownPipeLine(filePath))
                .run();
        System.out.println(fileName + " download over!");

    }

}
