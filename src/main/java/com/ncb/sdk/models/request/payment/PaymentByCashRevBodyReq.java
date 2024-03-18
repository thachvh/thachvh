package com.ncb.sdk.models.request.payment;

import lombok.Data;

import java.util.List;

@Data
public class PaymentByCashRevBodyReq {
    public String functionCode;
    public String transactionId;
    public String company;
}
