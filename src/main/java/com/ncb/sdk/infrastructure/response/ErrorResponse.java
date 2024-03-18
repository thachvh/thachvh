package com.ncb.sdk.infrastructure.response;

import com.ncb.sdk.infrastructure.common.AppConstants;

public class ErrorResponse extends BaseResponse{

    public ErrorResponse(String message, String code) {
        super(AppConstants.SYSTEM_ERROR, message, code);
    }

    public ErrorResponse(String status, String message, String code) {
        super(status, message, code);
    }

}
