package com.ncb.sdk.services.impl;

import com.google.gson.Gson;
import com.ncb.sdk.infrastructure.common.appenum.AccountServiceEnum;
import com.ncb.sdk.infrastructure.helper.LogHelper;
import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.infrastructure.response.ResponseUtility;
import com.ncb.sdk.models.BaseRequest;
import com.ncb.sdk.models.request.account.GetListAccountInfoByCustomerBodyReq;
import com.ncb.sdk.models.request.account.GetListAccountInfoByCustomerRequest;
import com.ncb.sdk.models.request.account.GetAccountInfoByIdBodyReq;
import com.ncb.sdk.models.request.account.GetAccountInfoByIdRequest;
import com.ncb.sdk.models.request.header.HeaderRequest;
import com.ncb.sdk.models.response.fillter.AuthenInfo;
import com.ncb.sdk.services.IAccountService;
import com.ncb.sdk.services.IFillterKeyService;
import com.ncb.sdk.infrastructure.common.AppConfig;
import com.ncb.sdk.infrastructure.common.AppConstants;
import com.ncb.sdk.utils.GetBaseHeader;
import com.ncb.sdk.utils.UnirestUtil;

import java.util.HashMap;
import java.util.Objects;

public class AccountServiceImpl implements IAccountService {
    private LogHelper logHelper = new LogHelper(AccountServiceImpl.class);
    private ResponseUtility responseUtility = new ResponseUtility(AccountServiceImpl.class);
    private UnirestUtil unirestUtil;
    private IFillterKeyService fillterKeyService;
    private GetBaseHeader getBaseHeader;

    public AccountServiceImpl() {
        unirestUtil = new UnirestUtil();
        fillterKeyService = new FillterKeyServiceImpl();
        getBaseHeader = new GetBaseHeader();
    }

    @Override
    public BaseResponse getAccountInfoById(AuthenInfo authenInfo, String id) {
        try{

            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", AccountServiceEnum.ACCOUNT_UNAUTHORZIRED.getValue());
            }

            GetAccountInfoByIdRequest getAccountInfoByIdRequest = new GetAccountInfoByIdRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            getAccountInfoByIdRequest.setHeader(headerRequest);
            GetAccountInfoByIdBodyReq bodyReq = new GetAccountInfoByIdBodyReq();
            bodyReq.setId(id);
            bodyReq.setFunctionCode(AppConstants.GET_ACCOUNT_INFO_BY_ID);
            getAccountInfoByIdRequest.setBodyReq(bodyReq);
            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setGetAccountInfoByIdReq(getAccountInfoByIdRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String getAccountInfoByIdResponse = unirestUtil.post(AppConfig.IBMB_URL+ AppConfig.GET_ACCOUNT_INFO_BY_ID, header, jsonString);

            return responseUtility.successResponse(getAccountInfoByIdResponse);
        }catch (Exception e){
            logHelper.error(e, AccountServiceEnum.ACCOUNT_SERVICE_ENUM_1.getValue());
            return responseUtility.internalServerException("Internal Error", AccountServiceEnum.ACCOUNT_SERVICE_ENUM_1.getValue());
        }

    }

    @Override
    public BaseResponse getListAccountInfoByCustomer(AuthenInfo authenInfo, String customer) {
        try{

            Integer a = Integer.parseInt("testExp");

            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", AccountServiceEnum.ACCOUNT_UNAUTHORZIRED.getValue());
            }

            GetListAccountInfoByCustomerRequest getListAccountInfoByCustomerRequest = new GetListAccountInfoByCustomerRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            getListAccountInfoByCustomerRequest.setHeader(headerRequest);
            GetListAccountInfoByCustomerBodyReq bodyReq = new GetListAccountInfoByCustomerBodyReq();
            bodyReq.setFunctionCode(AppConstants.GET_LIST_ACCOUNT_BY_CUSTOMER);
            bodyReq.setCustomer(customer);
            getListAccountInfoByCustomerRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setGetListAccountByCustomerReq(getListAccountInfoByCustomerRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String getListAccountInfoByCustomerResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.GET_LIST_ACCOUNT_BY_CUSTOMER, header, jsonString);

            return responseUtility.successResponse(getListAccountInfoByCustomerResponse);
        }catch (Exception e){
            logHelper.error(e, AccountServiceEnum.ACCOUNT_SERVICE_ENUM_2.getValue());
            return responseUtility.internalServerException("Internal Error", AccountServiceEnum.ACCOUNT_SERVICE_ENUM_2.getValue());
        }
    }

}
