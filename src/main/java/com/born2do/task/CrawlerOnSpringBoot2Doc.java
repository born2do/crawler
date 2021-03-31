package com.born2do.task;

import com.born2do.webmagic.downloader.selenium.SeleniumDownloader;
import com.overzealous.remark.Remark;
import org.springframework.scheduling.annotation.Scheduled;
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
 * 获取《SpringBoot2核心技术与响应式编程》教学文档
 * 说明：“语雀”前端页面较为复杂，数据有多层加密，且主要由Ajax渲染页面数据，在这里并没有对代码块以及思维导图进行进一步处理，需人工处理
 *
 * @author chenhy
 * @date 2021/3/22
 */
@Component
public class CrawlerOnSpringBoot2Doc implements PageProcessor {

    private static final String website = "https://www.yuque.com/atguigu/springboot";

    private static final String file = "D:\\SpringBoot2核心技术与响应式编程.md";

    private Site site = Site.me().setCharset("UTF8") // 编码格式
            .setTimeOut(1000 * 30) // 超时时间
            .setRetrySleepTime(1000 * 5) // 重试时间间隔
            .setRetryTimes(10); // 重试次数

    @Override
    public void process(Page page) {
        // 获取所有目录的url，并加入爬虫队列中
        if (website.equals(page.getUrl().toString())) {
            List<String> urls = page.getHtml().xpath("//span[@class='name']").links().all();
            for (String url : urls) {
                page.addTargetRequest(url);
            }
        } else {
            // 获取内容
            String content = page.getHtml().xpath("//div[@class='index-module_title_1s0gC']").toString()
                    + page.getHtml().xpath("//div[@class='yuque-doc-content']").toString();
            // 将获取到的内容从HTML格式转换为Markdown格式
            Remark remark = new Remark();
            content = remark.convert(content);
            page.putField("content", content);
            System.out.println(page.getUrl() + "   download over!");
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

//    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    private void mainProcess() throws IOException {
        Path filePath = Paths.get(file);
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }
        Files.createFile(filePath);
        Spider.create(new CrawlerOnSpringBoot2Doc())
                .addUrl(website)
                .setDownloader(new SeleniumDownloader("D:\\chromedriver_win32\\chromedriver.exe"))
                .thread(1)
                .addPipeline(new MarkdownPipeLine(filePath))
                .run();
        System.out.println("process is over!");
    }
}
