package com.born2do.crawler.log;

/**
 * @author chenhy
 * @date 2021/8/31
 */
public interface ILogger {

    /**
     * trace级别日志
     *
     * @param message 日志内容
     */
    void trace(String message);

    /**
     * debug级别日志
     *
     * @param message 日志内容
     */
    void debug(String message);

    /**
     * info级别日志
     *
     * @param message 日志内容
     */
    void info(String message);

    /**
     * warn级别日志
     *
     * @param message 日志内容
     */
    void warn(String message);

    /**
     * error级别日志
     *
     * @param message 日志内容
     */
    void error(String message);

    /**
     * trace级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    void trace(String message, String fileName);

    /**
     * debug级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    void debug(String message, String fileName);

    /**
     * info级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    void info(String message, String fileName);

    /**
     * warn级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    void warn(String message, String fileName);

    /**
     * error级别日志，写入文件
     *
     * @param message  日志内容
     * @param fileName 日志文件名
     */
    void error(String message, String fileName);

    /**
     * isTraceEnabled
     *
     * @return true/false
     */
    boolean isTraceEnabled();

    /**
     * isDebugEnabled
     *
     * @return true/false
     */
    boolean isDebugEnabled();

    /**
     * isInfoEnabled
     *
     * @return true/false
     */
    boolean isInfoEnabled();

    /**
     * isWarnEnabled
     *
     * @return true/false
     */
    boolean isWarnEnabled();

    /**
     * isErrorEnabled
     *
     * @return true/false
     */
    boolean isErrorEnabled();

}
