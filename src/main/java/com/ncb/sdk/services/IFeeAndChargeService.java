package com.ncb.sdk.services;

import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.models.response.fillter.AuthenInfo;

public interface IFeeAndChargeService {
    public BaseResponse ChargeFeeCHG(AuthenInfo authenInfo);
}
