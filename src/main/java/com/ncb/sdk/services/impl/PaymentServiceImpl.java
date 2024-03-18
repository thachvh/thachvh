package com.ncb.sdk.services.impl;

import com.google.gson.Gson;
import com.ncb.sdk.infrastructure.common.appenum.AccountServiceEnum;
import com.ncb.sdk.infrastructure.common.appenum.CustomerServiceEnum;
import com.ncb.sdk.infrastructure.common.appenum.PaymentServiceEnum;
import com.ncb.sdk.infrastructure.helper.LogHelper;
import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.infrastructure.response.ResponseUtility;
import com.ncb.sdk.models.BaseRequest;
import com.ncb.sdk.models.request.header.HeaderRequest;
import com.ncb.sdk.models.request.payment.*;
import com.ncb.sdk.models.response.fillter.AuthenInfo;
import com.ncb.sdk.services.IFillterKeyService;
import com.ncb.sdk.services.IPaymentService;
import com.ncb.sdk.infrastructure.common.AppConfig;
import com.ncb.sdk.infrastructure.common.AppConstants;
import com.ncb.sdk.utils.GetBaseHeader;
import com.ncb.sdk.utils.UnirestUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class PaymentServiceImpl implements IPaymentService {
    private LogHelper logHelper = new LogHelper(PaymentServiceImpl.class);
    private ResponseUtility responseUtility = new ResponseUtility(CustomerServiceImpl.class);
    private UnirestUtil unirestUtil;
    private IFillterKeyService fillterKeyService;
    private GetBaseHeader getBaseHeader;

    public PaymentServiceImpl() {
        unirestUtil = new UnirestUtil();
        fillterKeyService = new FillterKeyServiceImpl();
        getBaseHeader = new GetBaseHeader();
    }


    @Override
    public BaseResponse PaymentByCash(AuthenInfo authenInfo) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", PaymentServiceEnum.PAYMENT_UNAUTHORZIRED.getValue());
            }

            PaymentByCashRequest paymentByCashRequest = new PaymentByCashRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            paymentByCashRequest.setHeader(headerRequest);
            PaymentByCashBodyReq bodyReq = new PaymentByCashBodyReq();
            bodyReq.setFunctionCode(AppConstants.PAYMENT_BY_CASH);
            bodyReq.setIsCheckCharges("TRUE");
            bodyReq.setTransactionCode("20");

            PaymentByCashBodyReqAccount1 paymentByCashBodyReqAccount1 = new PaymentByCashBodyReqAccount1();
            paymentByCashBodyReqAccount1.setAccount("VND1000199990115");
            paymentByCashBodyReqAccount1.setCurrency("");
            paymentByCashBodyReqAccount1.setAmountLocal("1000000");
            paymentByCashBodyReqAccount1.setAmountFcy("1000");
            bodyReq.setAccount1(paymentByCashBodyReqAccount1);

            PaymentByCashBodyReqAccount2 paymentByCashBodyReqAccount2 = new PaymentByCashBodyReqAccount2();
            paymentByCashBodyReqAccount2.setAccount("PL52114");
            paymentByCashBodyReqAccount2.setNarrative("TEST NARRATIVE2");
            bodyReq.setAccount2(paymentByCashBodyReqAccount2);

            bodyReq.setNationalId("VN");
            bodyReq.setNcbProfitDept("9115");

            List<String> listFlexRefInfo = new ArrayList<>();
            listFlexRefInfo.add("345435");
            listFlexRefInfo.add("345345");
            listFlexRefInfo.add("3454");
            bodyReq.setFlexRefInfo(listFlexRefInfo);

            bodyReq.setCompany("VN0010115");

            paymentByCashRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setThanhToanNopTienMatReq(paymentByCashRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String paymentByCashResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.PAYMENT_BY_CASH, header, jsonString);
            return responseUtility.successResponse(paymentByCashResponse);
        }catch (Exception e){
            logHelper.error(e, PaymentServiceEnum.PAYMENT_SERVICE_ENUM_1.getValue());
            return responseUtility.internalServerException("Internal Error", PaymentServiceEnum.PAYMENT_SERVICE_ENUM_1.getValue());
        }

    }

    @Override
    public BaseResponse PaymentByCashRev(AuthenInfo authenInfo, String transactionId, String company) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", PaymentServiceEnum.PAYMENT_UNAUTHORZIRED.getValue());
            }

            PaymentByCashRevRequest paymentByCashRevRequest = new PaymentByCashRevRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            paymentByCashRevRequest.setHeader(headerRequest);
            PaymentByCashRevBodyReq bodyReq = new PaymentByCashRevBodyReq();
            bodyReq.setFunctionCode(AppConstants.PAYMENT_BY_CASH_REV);
            bodyReq.setTransactionId(transactionId);
            bodyReq.setCompany(company);
            paymentByCashRevRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setThanhToanNopTienMatRevReq(paymentByCashRevRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String paymentByCashRevResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.PAYMENT_BY_CASH_REV, header, jsonString);

            return responseUtility.successResponse(paymentByCashRevResponse);
        }catch (Exception e){
            logHelper.error(e, PaymentServiceEnum.PAYMENT_SERVICE_ENUM_2.getValue());
            return responseUtility.internalServerException("Internal Error", PaymentServiceEnum.PAYMENT_SERVICE_ENUM_2.getValue());
        }

    }

    @Override
    public BaseResponse PaymentByCashSee(AuthenInfo authenInfo, String transactionId, String company) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", PaymentServiceEnum.PAYMENT_UNAUTHORZIRED.getValue());
            }

            PaymentByCashSeeRequest paymentByCashSeeRequest = new PaymentByCashSeeRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            paymentByCashSeeRequest.setHeader(headerRequest);
            PaymentByCashSeeBodyReq bodyReq = new PaymentByCashSeeBodyReq();
            bodyReq.setFunctionCode(AppConstants.PAYMENT_BY_CASH_SEE);
            bodyReq.setTransactionId(transactionId);
            bodyReq.setCompany(company);
            paymentByCashSeeRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setThanhToanNopTienMatSeeReq(paymentByCashSeeRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String paymentByCashSeeResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.PAYMENT_BY_CASH_SEE, header, jsonString);

            return responseUtility.successResponse(paymentByCashSeeResponse);
        }catch (Exception e){
            logHelper.error(e, PaymentServiceEnum.PAYMENT_SERVICE_ENUM_3.getValue());
            return responseUtility.internalServerException("Internal Error", PaymentServiceEnum.PAYMENT_SERVICE_ENUM_3.getValue());
        }

    }
}
