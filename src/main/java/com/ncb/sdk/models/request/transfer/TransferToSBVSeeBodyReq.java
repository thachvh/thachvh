package com.ncb.sdk.models.request.transfer;

import lombok.Data;

@Data
public class TransferToSBVSeeBodyReq {
    public String functionCode;
    public String transactionId;
    public String company;
}