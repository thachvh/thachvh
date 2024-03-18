package com.ncb.sdk.models.request.payment;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class PaymentByCashSeeRequest {
    public HeaderRequest header;
    public PaymentByCashSeeBodyReq bodyReq;

}
