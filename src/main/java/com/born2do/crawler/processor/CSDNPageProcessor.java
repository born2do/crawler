package com.born2do.crawler.processor;

import com.born2do.crawler.constant.PathConstant;
import com.born2do.crawler.pipeline.MarkdownPipeLine;
import com.overzealous.remark.Remark;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author chenhy
 * @date 2021/9/2
 */
public class CSDNPageProcessor implements PageProcessor {

    private static final String[] website = {"https://blog.csdn.net/u011863024/article/details/113667634",
                                                "https://blog.csdn.net/u011863024/article/details/113667946"};

    private static final String dir = PathConstant.DIR;

    private static final String fileName = "Spring Boot 2 学习笔记.md";

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
        // 获取内容
        String content = page.getHtml().xpath("//article[@class='baidu_pl']").toString();
        page.putField("content", content);
        System.out.println(page.getUrl() + " ===> download over!");
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
        Spider.create(new CSDNPageProcessor()).addUrl(website)
                .thread(1)
                .addPipeline(new MarkdownPipeLine(filePath))
                .run();
        System.out.println("file download over!");
    }
}
