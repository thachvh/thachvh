package com.ncb.sdk.infrastructure.response;

public class SuccessResponse extends BaseResponse{
    public SuccessResponse(Object data) {
        super(data);
    }

    public SuccessResponse(String message, Object data) {
        super("200", message, data);
    }


}
