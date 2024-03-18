package com.ncb.sdk.models.request.customer;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class GetCifByLegalRequest {
    public HeaderRequest header;
    public GetCifByLegalBodyReq bodyReq;

}
