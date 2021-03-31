package com.born2do.task;

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

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @author chenhy
 * @date 2021/3/16
 */
@Component
public class CrawlerOnYalayi implements PageProcessor {

    // 官网名称
    private static String webName = "雅拉伊";
    // 官网地址
    private static String webUrl = "https://www.yalayi.com/";
    // 最小地址页数
    private static int minPageNumber = 15;
    // 最大地址页数
    private static int maxPageNumber = 820;
    // 本地根目录
    private static String root = "D:\\yalayi";

    private Site site = Site.me().setCharset("UTF8")// 编码格式
            .setTimeOut(1000 * 30)// 超时时间
            .setRetrySleepTime(1000 * 5)// 重试时间间隔
            .setRetryTimes(10);// 重试次数

    @Override
    public void process(Page page) {
        String pageUrl = page.getUrl().toString().trim();
        if ("https://www.yalayi.com/".equals(pageUrl)) {
            for (int i = minPageNumber; i <= maxPageNumber; i++) {
                page.addTargetRequest(pageUrl + "/gallery/" + i + ".html");
            }
            System.out.println("详情页地址添加完毕！");
        } else {
            // 模特名称
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
            // 作品简介
            String introduction = page.getHtml().xpath("//div[@class='content']/div[@class='jieshao']/p")
                    .nodes().get(3).$("p", "text").toString();
            // 作品标签
            String lables = "";
            List<Selectable> labelList = page.getHtml().xpath("//div[@class='content']/div[@class='jieshao']/p")
                    .nodes().get(4).$("a").nodes();
            for (Selectable label : labelList) {
                lables = lables + "," + label.$("a", "text").toString();
            }
            // 图片源地址
            List<Selectable> picUrl = page.getHtml().$("div.main > div.imgs-box > div.bigimg")
                    .nodes().get(0).$("img.lazy", "data-original").nodes();
            // 本地存储绝对路径
            String path = root + "\\" + modelName + "\\" + artName;
            boolean dirExist = true;
            if (null != picUrl && !picUrl.isEmpty()) {
                dirExist = mkdir(path);
            } else {
                return;
            }
            if (dirExist) {
                // 下载图片
                for (Selectable selectable : picUrl) {
                    int result = downlaodPicFromYalayi(selectable.toString(), path);
                    if (0 == result) {
                        System.out.println(selectable.toString() + "文件下载完成");
                    } else if (2 == result) {
                        System.out.println(selectable.toString() + "文件已经存在");
                    } else {
                        System.out.println(selectable.toString() + "文件下载失败");
                    }
                }
            } else {
                return;
            }
            System.out.println(pageUrl + "下载完成");
        }

    }

    private int downlaodPicFromYalayi(String link, String path) {
        int rtcode = 0;
        String fileName = link.substring(link.lastIndexOf("/") + 1);
        try {
            File file = new File(path + "\\" + fileName + ".jpg");
            if (file.exists()) {
                rtcode = 2;
            } else {
                URL url = new URL(link);
                URLConnection con = url.openConnection();
                InputStream inStream = con.getInputStream();
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = inStream.read(buf)) != -1) {
                    outStream.write(buf, 0, len);
                }
                inStream.close();
                outStream.close();
                FileOutputStream op = new FileOutputStream(file);
                op.write(outStream.toByteArray());
                op.close();
            }
        } catch (MalformedURLException e) {
            rtcode = 1;
            e.printStackTrace();
        } catch (IOException e) {
            rtcode = 1;
            e.printStackTrace();
        }
        return rtcode;
    }

    private boolean mkdir(String path) {
        boolean isSucceed = true;
        try {
            File files = new File(path);
            if (!files.exists()) {
                files.mkdirs();
            }
        } catch (Exception e) {
            isSucceed = false;
            System.out.println("文件夹创建失败：" + path);
        }
        return isSucceed;
    }

    @Override
    public Site getSite() {
        return site;
    }

//    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void mainProcess() {
        Spider.create(new CrawlerOnYalayi()).addUrl(webUrl)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(1000)))
                .thread(10).run();
    }
}
