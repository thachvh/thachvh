package com.ncb.sdk.models.request.transfer;

import lombok.Data;

import java.util.List;

@Data
public class GetFlexTransInfoByIdBodyReq {
    public String functionCode;
    public String id;
}
