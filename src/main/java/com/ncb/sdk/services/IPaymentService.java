package com.ncb.sdk.services;

import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.models.response.fillter.AuthenInfo;

public interface IPaymentService {
    public BaseResponse PaymentByCash(AuthenInfo authenInfo);
    public BaseResponse PaymentByCashRev(AuthenInfo authenInfo, String transactionId, String company);
    public BaseResponse PaymentByCashSee(AuthenInfo authenInfo, String transactionId, String company);
}
