package com.born2do.crawler.mapper;

import com.born2do.crawler.log.ILogger;
import com.born2do.crawler.log.LoggerImpl;
import com.born2do.crawler.pojo.Systm;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chenhy
 * @date 2021/8/31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SystmMapperTest {
    private static final ILogger logger = new LoggerImpl(SystmMapperTest.class);

    @Autowired
    private SystmMapper systmMapper;

    @org.junit.Test
    public void getAllSystms() {
        logger.info("测试开始", "batch");
        List<Systm> allSystms = systmMapper.getAllSystms();
        System.out.println(allSystms.toString());
        logger.info("测试结束", "batch");

    }
}