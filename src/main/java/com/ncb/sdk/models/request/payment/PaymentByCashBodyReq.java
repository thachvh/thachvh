package com.ncb.sdk.models.request.payment;

import lombok.Data;

import java.util.List;

@Data
public class PaymentByCashBodyReq {
    public String functionCode;
    public String isCheckCharges;
    public String transactionCode;
    public PaymentByCashBodyReqAccount1 account1;
    public PaymentByCashBodyReqAccount2 account2;
    public String nationalId;
    public String ncbProfitDept;
    public List<String> flexRefInfo;
    public String company;
}
