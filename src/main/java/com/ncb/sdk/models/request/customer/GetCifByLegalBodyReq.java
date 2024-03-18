package com.ncb.sdk.models.request.customer;

import lombok.Data;

@Data
public class GetCifByLegalBodyReq {
    public String functionCode;
    public String legalId;

}
