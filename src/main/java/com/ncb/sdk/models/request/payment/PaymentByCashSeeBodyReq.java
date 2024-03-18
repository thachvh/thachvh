package com.ncb.sdk.models.request.payment;

import lombok.Data;

import java.util.List;

@Data
public class PaymentByCashSeeBodyReq {
    public String functionCode;
    public String transactionId;
    public String company;
}