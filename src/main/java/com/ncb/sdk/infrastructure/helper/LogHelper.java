package com.ncb.sdk.infrastructure.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
    private Logger logger;

    public LogHelper(Class<?> clazz) {
        this.logger = LogManager.getLogger(clazz);
    }

    public void trace(String message) {
        logger.trace(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(Exception e) {
        logger.error("Exception: ", e);
    }

    public void error(Exception e, String errorCode) {
        logger.error("ErrorCode: "+ errorCode, e);
    }

    public void fatal(String message) {
        logger.fatal(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
