package com.ncb.sdk.infrastructure.response;

import com.ncb.sdk.infrastructure.helper.LogHelper;
import com.ncb.sdk.infrastructure.common.AppConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.properties.PropertiesConfigurationFactory;

import java.io.FileInputStream;
import java.io.InputStream;

public class ResponseUtility {
//    public static LogHelper logHelper = new LogHelper(ResponseUtility.class);

//    static {
//        try {
//            // Đường dẫn tới file cấu hình tùy chỉnh
//            String configPath = "../resources/log4j2-ncb-sdk.properties";
//            InputStream configStream = new FileInputStream(configPath);
//            ConfigurationSource source = new ConfigurationSource(configStream);
//            ConfigurationFactory factory = new PropertiesConfigurationFactory();
//            // Thiết lập cấu hình cho Log4j2
//            ConfigurationFactory.setConfigurationFactory(factory);
//            LogManager.getContext(false).;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    private Logger logHelper;
    public ResponseUtility(Class<?> clazz) {
        this.logHelper = LogManager.getLogger(clazz);
    }
    public SuccessResponse successResponse(Object data) {
        SuccessResponse successResponse = new SuccessResponse(data);
        logHelper.info(String.valueOf(successResponse));
        return successResponse;
    }

    public ErrorResponse failureResponse(String message, String code) {
        return new ErrorResponse(message, code);
    }

    public ErrorResponse badRequestException(String message, String code) {
        ErrorResponse errorResponse = new ErrorResponse(AppConstants.SYSTEM_BAD_REQUEST,message, code);
        logHelper.info(String.valueOf(errorResponse));
        return errorResponse;
    }

    public ErrorResponse internalServerException(String message, String code) {
        ErrorResponse errorResponse = new ErrorResponse(message, code);
        logHelper.info(String.valueOf(errorResponse));
        return errorResponse;
    }

    public ErrorResponse unauthorizedException(String message, String code) {
        ErrorResponse errorResponse = new ErrorResponse(message, code);
        logHelper.info(String.valueOf(errorResponse));
        return errorResponse;
    }

}
