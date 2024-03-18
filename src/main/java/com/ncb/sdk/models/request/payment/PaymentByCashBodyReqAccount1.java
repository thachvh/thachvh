package com.ncb.sdk.models.request.payment;

import lombok.Data;

@Data
public class PaymentByCashBodyReqAccount1 {
    public String account;
    public String currency;
    public String amountLocal;
    public String amountFcy;
}
