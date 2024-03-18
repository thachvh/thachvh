package com.ncb.sdk.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.models.response.fillter.AuthenInfo;

public interface IAccountService {
    public BaseResponse getAccountInfoById(AuthenInfo authenInfo, String id);
    public BaseResponse getListAccountInfoByCustomer(AuthenInfo authenInfo, String customer);

}
