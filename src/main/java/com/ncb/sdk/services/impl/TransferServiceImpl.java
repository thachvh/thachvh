package com.ncb.sdk.services.impl;

import com.google.gson.Gson;
import com.ncb.sdk.infrastructure.common.appenum.AccountServiceEnum;
import com.ncb.sdk.infrastructure.common.appenum.TransferServiceEnum;
import com.ncb.sdk.infrastructure.helper.LogHelper;
import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.infrastructure.response.ResponseUtility;
import com.ncb.sdk.models.BaseRequest;
import com.ncb.sdk.models.request.header.HeaderRequest;
import com.ncb.sdk.models.request.transfer.*;
import com.ncb.sdk.models.response.fillter.AuthenInfo;
import com.ncb.sdk.services.IFillterKeyService;
import com.ncb.sdk.services.ITransferService;
import com.ncb.sdk.infrastructure.common.AppConfig;
import com.ncb.sdk.infrastructure.common.AppConstants;
import com.ncb.sdk.utils.GetBaseHeader;
import com.ncb.sdk.utils.UnirestUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TransferServiceImpl implements ITransferService {
    private LogHelper logHelper = new LogHelper(TransferServiceImpl.class);
    private ResponseUtility responseUtility = new ResponseUtility(CustomerServiceImpl.class);
    private UnirestUtil unirestUtil;
    private IFillterKeyService fillterKeyService;
    private GetBaseHeader getBaseHeader;

    public TransferServiceImpl() {
        unirestUtil = new UnirestUtil();
        fillterKeyService = new FillterKeyServiceImpl();
        getBaseHeader = new GetBaseHeader();
    }


    @Override
    public BaseResponse TransferToSBV(AuthenInfo authenInfo) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", TransferServiceEnum.TRANSFER_UNAUTHORZIRED.getValue());
            }

            TransferToSBVRequest transferToSBVRequest = new TransferToSBVRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            transferToSBVRequest.setHeader(headerRequest);
            TransferToSBVBodyReq bodyReq = new TransferToSBVBodyReq();
            bodyReq.setFunctionCode(AppConstants.TRANSFE_TO_SBV);

            List<String> listFlexRefInfo = new ArrayList<>();
            listFlexRefInfo.add("IDFLEX2");
            listFlexRefInfo.add("USER1");
            listFlexRefInfo.add("USER2");
            bodyReq.setFlexRefInfo(listFlexRefInfo);

            TransferToSBVBodyReqDebitAccount transferToSBVBodyReqDebitAccount = new TransferToSBVBodyReqDebitAccount();
            transferToSBVBodyReqDebitAccount.setAcctNo("VND12501000100011");
            transferToSBVBodyReqDebitAccount.setCurrency("VND");
            transferToSBVBodyReqDebitAccount.setAmount("50000000");
            transferToSBVBodyReqDebitAccount.setValueDate("20231023");
            bodyReq.setDebitAccount(transferToSBVBodyReqDebitAccount);

            TransferToSBVBodyReqCreditAccount transferToSBVBodyReqCreditAccount = new TransferToSBVBodyReqCreditAccount();
            transferToSBVBodyReqCreditAccount.setAcctNo("500000000224");
            bodyReq.setCreditAccount(transferToSBVBodyReqCreditAccount);

            bodyReq.setOrderingCust("CN Ha noi Thuc hien rut tien mat tu NHNN Thuc hien rut tien mat tu NHNN ");
            bodyReq.setPaymentDetails("Thuc hien rut tien mat tu NHNN Thuc hien rut tien mat tu NHNN Thuc hien rut tien mat tu NHNN");
            bodyReq.setProfitCentreDept("9300");
            bodyReq.setCompany("VN0010101");

            transferToSBVRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setNopRutTienNHNNReq(transferToSBVRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String transferToSBVResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.TRANSFER_TO_SBV, header, jsonString);

            return responseUtility.successResponse(transferToSBVResponse);
        }catch (Exception e){
            logHelper.error(e, TransferServiceEnum.TRANSFER_SERVICE_ENUM_1.getValue());
            return responseUtility.internalServerException("Internal Error", TransferServiceEnum.TRANSFER_SERVICE_ENUM_1.getValue());
        }

    }

    @Override
    public BaseResponse TransferToSBVRev(AuthenInfo authenInfo, String transactionId, String company) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", TransferServiceEnum.TRANSFER_UNAUTHORZIRED.getValue());
            }

            TransferToSBVRevRequest transferToSBVRevRequest = new TransferToSBVRevRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            transferToSBVRevRequest.setHeader(headerRequest);
            TransferToSBVRevBodyReq bodyReq = new TransferToSBVRevBodyReq();
            bodyReq.setFunctionCode(AppConstants.TRANSFE_TO_SBV_REV);
            bodyReq.setTransactionId(transactionId);
            bodyReq.setCompany(company);
            transferToSBVRevRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setNopRutTienNHNNRevReq(transferToSBVRevRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String transferToSBVRevResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.TRANSFER_TO_SBV_REV, header, jsonString);

            return responseUtility.successResponse(transferToSBVRevResponse);
        }catch (Exception e){
            logHelper.error(e, TransferServiceEnum.TRANSFER_SERVICE_ENUM_2.getValue());
            return responseUtility.internalServerException("Internal Error", TransferServiceEnum.TRANSFER_SERVICE_ENUM_2.getValue());
        }


    }

    @Override
    public BaseResponse TransferSBVSee(AuthenInfo authenInfo, String transactionId, String company) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", TransferServiceEnum.TRANSFER_UNAUTHORZIRED.getValue());
            }

            TransferToSBVSeeRequest transferToSBVSeeRequest = new TransferToSBVSeeRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            transferToSBVSeeRequest.setHeader(headerRequest);
            TransferToSBVSeeBodyReq bodyReq = new TransferToSBVSeeBodyReq();
            bodyReq.setFunctionCode(AppConstants.TRANSFE_TO_SBV_SEE);
            bodyReq.setTransactionId(transactionId);
            bodyReq.setCompany(company);
            transferToSBVSeeRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setNopRutTienNHNNSeeReq(transferToSBVSeeRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String transferToSBVSeeResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.TRANSFER_TO_SBV_SEE, header, jsonString);

            return responseUtility.successResponse(transferToSBVSeeResponse);
        }catch (Exception e){
            logHelper.error(e, TransferServiceEnum.TRANSFER_SERVICE_ENUM_3.getValue());
            return responseUtility.internalServerException("Internal Error", TransferServiceEnum.TRANSFER_SERVICE_ENUM_3.getValue());
        }


    }

    @Override
    public BaseResponse GetFlexTransInfoById(AuthenInfo authenInfo, String id) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", TransferServiceEnum.TRANSFER_UNAUTHORZIRED.getValue());
            }

            GetFlexTransInfoByIdRequest getFlexTransInfoByIdRequest = new GetFlexTransInfoByIdRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            getFlexTransInfoByIdRequest.setHeader(headerRequest);
            GetFlexTransInfoByIdBodyReq bodyReq = new GetFlexTransInfoByIdBodyReq();
            bodyReq.setFunctionCode(AppConstants.GET_FLEX_TRANSINFO_BY_ID);
            bodyReq.setId(id);
            getFlexTransInfoByIdRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setGetFlexTransInfoByIdReq(getFlexTransInfoByIdRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String getFlexTransInfoByIdResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.GET_FLEX_TRANS_INFO_BY_ID, header, jsonString);

            return responseUtility.successResponse(getFlexTransInfoByIdResponse);
        }catch (Exception e){
            logHelper.error(e, TransferServiceEnum.TRANSFER_SERVICE_ENUM_4.getValue());
            return responseUtility.internalServerException("Internal Error", TransferServiceEnum.TRANSFER_SERVICE_ENUM_4.getValue());
        }

    }
}
