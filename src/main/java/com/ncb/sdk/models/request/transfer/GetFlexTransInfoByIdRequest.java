package com.ncb.sdk.models.request.transfer;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class GetFlexTransInfoByIdRequest {
    public HeaderRequest header;
    public GetFlexTransInfoByIdBodyReq bodyReq;
}
