package com.ncb.sdk.services.impl;

import com.google.gson.Gson;
import com.ncb.sdk.infrastructure.common.appenum.AccountServiceEnum;
import com.ncb.sdk.infrastructure.common.appenum.CustomerServiceEnum;
import com.ncb.sdk.infrastructure.helper.LogHelper;
import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.infrastructure.response.ResponseUtility;
import com.ncb.sdk.models.BaseRequest;
import com.ncb.sdk.models.request.customer.*;
import com.ncb.sdk.models.request.header.HeaderRequest;
import com.ncb.sdk.models.response.fillter.AuthenInfo;
import com.ncb.sdk.services.ICustomerService;
import com.ncb.sdk.services.IFillterKeyService;
import com.ncb.sdk.infrastructure.common.AppConfig;
import com.ncb.sdk.infrastructure.common.AppConstants;
import com.ncb.sdk.utils.GetBaseHeader;
import com.ncb.sdk.utils.UnirestUtil;

import java.util.HashMap;
import java.util.Objects;

public class CustomerServiceImpl implements ICustomerService {
    private LogHelper logHelper = new LogHelper(CustomerServiceImpl.class);
    private ResponseUtility responseUtility = new ResponseUtility(CustomerServiceImpl.class);
    private UnirestUtil unirestUtil;
    private IFillterKeyService fillterKeyService;
    private GetBaseHeader getBaseHeader;

    public CustomerServiceImpl() {
        unirestUtil = new UnirestUtil();
        fillterKeyService = new FillterKeyServiceImpl();
        getBaseHeader = new GetBaseHeader();
    }
    public Boolean verifyUserInfo(String cif) {
        System.out.println("verify User Info");
        return true;
    }

    @Override
    public String getCifByUserNameAndPassword(String userName, String password) {
        System.out.println("get Cif By UserName and Password");
        return null;
    }

    @Override
    public BaseResponse getCifByLegal(AuthenInfo authenInfo, String legalId){
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", CustomerServiceEnum.CUSTOMER_UNAUTHORZIRED.getValue());
            }

            GetCifByLegalRequest getCifByLegalRequest = new GetCifByLegalRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            getCifByLegalRequest.setHeader(headerRequest);
            GetCifByLegalBodyReq bodyReq = new GetCifByLegalBodyReq();
            bodyReq.setFunctionCode(AppConstants.GET_CIF_BY_LEGAL);
            bodyReq.setLegalId(legalId);
            getCifByLegalRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setGetCifByLegalReq(getCifByLegalRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String getCifByLegalResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.GET_CIF_BY_LEGAL, header, jsonString);

            return responseUtility.successResponse(getCifByLegalResponse);
        }catch (Exception e){
            logHelper.error(e, CustomerServiceEnum.CUSTOMER_SERVICE_ENUM_1.getValue());
            return responseUtility.internalServerException("Internal Error",CustomerServiceEnum.CUSTOMER_SERVICE_ENUM_1.getValue());
        }
    }

    @Override
    public BaseResponse getCustomerInfoById(AuthenInfo authenInfo, String id) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", CustomerServiceEnum.CUSTOMER_UNAUTHORZIRED.getValue());
            }

            GetCustomerInfoByIdRequest getCustomerInfoByIdRequest = new GetCustomerInfoByIdRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            getCustomerInfoByIdRequest.setHeader(headerRequest);
            GetCustomerInfoByIdBodyReq bodyReq = new GetCustomerInfoByIdBodyReq();
            bodyReq.setFunctionCode(AppConstants.GET_CUSTOMER_INFO_BY_ID);
            bodyReq.setId(id);
            getCustomerInfoByIdRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setGetCustomerInfoByIdReq(getCustomerInfoByIdRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String getCustomerInfoByIdResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.GET_CUSTOMER_INFO_BY_ID, header, jsonString);

            return responseUtility.successResponse(getCustomerInfoByIdResponse);
        }catch (Exception e){
            logHelper.error(e, CustomerServiceEnum.CUSTOMER_SERVICE_ENUM_2.getValue());
            return responseUtility.internalServerException("Internal Error",CustomerServiceEnum.CUSTOMER_SERVICE_ENUM_2.getValue());
        }
    }

    @Override
    public BaseResponse getSignatureByCif(AuthenInfo authenInfo, String imageReference) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", CustomerServiceEnum.CUSTOMER_UNAUTHORZIRED.getValue());
            }

            GetSignatureByCifRequest getSignatureByCifRequest = new GetSignatureByCifRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            getSignatureByCifRequest.setHeader(headerRequest);
            GetSignatureByCifBodyReq bodyReq = new GetSignatureByCifBodyReq();
            bodyReq.setFunctionCode(AppConstants.GET_SIGNATURE_BY_CIF);
            bodyReq.setImageReference(imageReference);
            getSignatureByCifRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setGetSignatureByCifReq(getSignatureByCifRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String getSignatureByCifResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.GET_SIGNATURE_BY_CIF, header, jsonString);

            return responseUtility.successResponse(getSignatureByCifResponse);
        }catch (Exception e){
            logHelper.error(e, CustomerServiceEnum.CUSTOMER_SERVICE_ENUM_3.getValue());
            return responseUtility.internalServerException("Internal Error", CustomerServiceEnum.CUSTOMER_SERVICE_ENUM_3.getValue());
        }
    }
}
