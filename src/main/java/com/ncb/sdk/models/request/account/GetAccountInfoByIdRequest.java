package com.ncb.sdk.models.request.account;

import com.ncb.sdk.models.request.header.HeaderClient;
import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class GetAccountInfoByIdRequest {
    public HeaderRequest header;
    public GetAccountInfoByIdBodyReq bodyReq;

}
