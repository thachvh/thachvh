package com.ncb.sdk.models.request.customer;

import lombok.Data;

@Data
public class GetSignatureByCifBodyReq {
    public String functionCode;
    public String imageReference;

}
