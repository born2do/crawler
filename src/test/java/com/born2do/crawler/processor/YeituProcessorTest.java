package com.born2do.crawler.processor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;

import static org.junit.Assert.*;

/**
 * @author chenhy
 * @date 2021/9/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YeituProcessorTest {

    @Test
    public void main() {
        String tagUrl = "https://www.yeitu.net/tag/youguowang/";
        Spider.create(new YeituProcessor())
                .addUrl(tagUrl)
                .run();
    }
}