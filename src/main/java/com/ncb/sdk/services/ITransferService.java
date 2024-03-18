package com.ncb.sdk.services;

import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.models.response.fillter.AuthenInfo;

public interface ITransferService {
    public BaseResponse TransferToSBV(AuthenInfo authenInfo);
    public BaseResponse TransferToSBVRev(AuthenInfo authenInfo, String transactionId, String company);
    public BaseResponse TransferSBVSee(AuthenInfo authenInfo, String transactionId, String company);
    public BaseResponse GetFlexTransInfoById(AuthenInfo authenInfo, String id);

}
