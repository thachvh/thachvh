package com.ncb.sdk.services;

import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.models.response.fillter.AuthenInfo;

public interface ICustomerService {
    public Boolean verifyUserInfo(String cif);

    public String getCifByUserNameAndPassword(String userName, String Password);

    public BaseResponse getCifByLegal(AuthenInfo authenInfo, String legalId);
    public BaseResponse getCustomerInfoById(AuthenInfo authenInfo, String id);
    public BaseResponse getSignatureByCif(AuthenInfo authenInfo, String imageReference);


}
