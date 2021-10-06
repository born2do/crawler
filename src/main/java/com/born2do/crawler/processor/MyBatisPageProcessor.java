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
import java.util.List;

/**
 * 获取MyBatis官方文档
 * @author chenhy
 * @date 2021/9/1
 */
public class MyBatisPageProcessor implements PageProcessor {

    private static final String website = "https://mybatis.org/mybatis-3/zh/index.html";

    private static final String dir = PathConstant.DIR;

    private static final String fileName = "mybatis.md";

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
            List<String> urls = page.getHtml().xpath("//nav[@class='sidebar-nav']").links().all();
            for (String url : urls) {
                // 官网首页有两个网址 'https://mybatis.org/mybatis-3/zh/index.html' 和 'https://mybatis.org/mybatis-3/zh/index.html#'
                // 此处是对url的去重
                if (!website.equals(url.substring(0, url.length()-1))) {
                    page.addTargetRequest(url);
                }
            }
        }
        // 获取内容
        String content = page.getHtml().xpath("//main").toString();
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
        Spider.create(new MyBatisPageProcessor()).addUrl(website)
                .thread(1)
                .addPipeline(new MarkdownPipeLine(filePath))
                .run();
        System.out.println(fileName + " download over!");
    }
}
