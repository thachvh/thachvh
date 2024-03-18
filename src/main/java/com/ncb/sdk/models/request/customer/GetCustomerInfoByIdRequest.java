package com.ncb.sdk.models.request.customer;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class GetCustomerInfoByIdRequest {
    public HeaderRequest header;
    public GetCustomerInfoByIdBodyReq bodyReq;

}
