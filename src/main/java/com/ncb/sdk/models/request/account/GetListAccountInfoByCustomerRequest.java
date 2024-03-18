package com.ncb.sdk.models.request.account;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class GetListAccountInfoByCustomerRequest {
    public HeaderRequest header;
    public GetListAccountInfoByCustomerBodyReq bodyReq;

}
