package com.ncb.sdk.models.request.payment;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class PaymentByCashRevRequest {
    public HeaderRequest header;
    public PaymentByCashRevBodyReq bodyReq;

}
