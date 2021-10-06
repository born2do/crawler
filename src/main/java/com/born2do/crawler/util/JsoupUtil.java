package com.born2do.crawler.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author chenhy
 * @date 2021/9/11
 */
public class JsoupUtil {

    public static Document getDocument(String url, int timeout, int retryTimes, int retrySleepTime) {
        for (int i = 0; i < retryTimes; i++) {
            Document document = null;
            try {
                document = Jsoup.connect(url).timeout(timeout).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (null != document) {
                return document;
            }
            if (0 < retrySleepTime) {
                try {
                    Thread.sleep(retrySleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
