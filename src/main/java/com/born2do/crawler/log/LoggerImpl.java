package com.born2do.crawler.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author chenhy
 * @date 2021/8/31
 */
public class LoggerImpl implements ILogger {

    private Class clazz;

    private Logger logger;

    public static final String LOG_FILE_NAME = "filename";

    public LoggerImpl(Class clazz) {
        this.clazz = clazz;
        this.logger = LoggerFactory.getLogger(clazz);
    }

    /**
     * trace级别日志
     *
     * @param message 日志内容
     */
    @Override
    public void trace(String message) {
        logger.trace(message);
    }

    /**
     * debug级别日志
     *
     * @param message 日志内容
     */
    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    /**
     * info级别日志
     *
     * @param message 日志内容
     */
    @Override
    public void info(String message) {
        logger.info(message);
    }

    /**
     * warn级别日志
     *
     * @param message 日志内容
     */
    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    /**
     * error级别日志
     *
     * @param message 日志内容
     */
    @Override
    public void error(String message) {
        logger.error(message);
    }

    /**
     * trace级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    @Override
    public void trace(String message, String fileName) {
        MDC.put(LOG_FILE_NAME, fileName);
        trace(message);
    }

    /**
     * debug级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    @Override
    public void debug(String message, String fileName) {
        MDC.put(LOG_FILE_NAME, fileName);
        debug(message);
    }

    /**
     * info级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    @Override
    public void info(String message, String fileName) {
        MDC.put(LOG_FILE_NAME, fileName);
        info(message);
    }

    /**
     * warn级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    @Override
    public void warn(String message, String fileName) {
        MDC.put(LOG_FILE_NAME, fileName);
        warn(message);
    }

    /**
     * error级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    @Override
    public void error(String message, String fileName) {
        MDC.put(LOG_FILE_NAME, fileName);
        error(message);
    }

    /**
     * isTraceEnabled
     *
     * @return true/false
     */
    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    /**
     * isDebugEnabled
     *
     * @return true/false
     */
    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * isInfoEnabled
     *
     * @return true/false
     */
    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    /**
     * isWarnEnabled
     *
     * @return true/false
     */
    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    /**
     * isErrorEnabled
     *
     * @return true/false
     */
    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

}
