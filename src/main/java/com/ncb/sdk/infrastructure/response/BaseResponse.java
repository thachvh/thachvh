package com.ncb.sdk.infrastructure.response;

import com.ncb.sdk.infrastructure.common.AppConstants;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaseResponse implements Serializable {
    private String status;
    private Date timestamp = new Date();
    private String message;
    private Object data;
    private String code;

    public BaseResponse(Object data) {
        super();
        this.status = AppConstants.SYSTEM_OK;
        this.message = AppConstants.SUCCESS;
        this.data = data;
    }

    public BaseResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(String status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public BaseResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String status, String message, Object data, String code) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.code = code;
    }
}
