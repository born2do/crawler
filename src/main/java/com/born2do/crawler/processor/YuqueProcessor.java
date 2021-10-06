package com.born2do.crawler.processor;

import com.born2do.crawler.selenium.SeleniumDownloader;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * “语雀”前端页面较为复杂，数据有多层加密，且主要由Ajax渲染页面数据
 * 这里使用 Selenium+chrome浏览器 爬取动态页面数据
 * 说明：由于本地的谷歌浏览器可能会自动升级，相应的驱动也要及时更换。
 * 驱动地址：http://npm.taobao.org/mirrors/chromedriver/
 * 当前应用浏览器驱动版本：93.0.4577.63
 * @author chenhy
 * @date 2021/9/9
 */
public class YuqueProcessor implements PageProcessor {

    private Site site = Site.me().setCharset("UTF-8")
            .setTimeOut(1000 * 30)
            .setRetrySleepTime(1000 * 5)
            .setRetryTimes(3);

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    @Override
    public void process(Page page) {
        List<String> urls = page.getHtml().xpath("//span[@class='name']").links().all();
        for (String url : urls) {
            System.out.println("目录网址：" + url);
        }
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

    public static void main(String[] args) {
        Spider.create(new YuqueProcessor())
                .addUrl("https://www.yuque.com/atguigu/springboot")
                .setDownloader(new SeleniumDownloader("D:/IdeaProjects/crawler/src/main/resources/chromedriver_win32_93.0.4577.63/chromedriver.exe"))
                .thread(1)
                .run();
    }
}
