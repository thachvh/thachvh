package com.ncb.sdk.services.impl;

import com.google.gson.Gson;
import com.ncb.sdk.infrastructure.common.appenum.AccountServiceEnum;
import com.ncb.sdk.infrastructure.common.appenum.FeeAndChargeServiceEnum;
import com.ncb.sdk.infrastructure.common.appenum.PaymentServiceEnum;
import com.ncb.sdk.infrastructure.helper.LogHelper;
import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.infrastructure.response.ResponseUtility;
import com.ncb.sdk.models.BaseRequest;
import com.ncb.sdk.models.request.feeandcharge.ChargeFeeBodyReqChargeCodes;
import com.ncb.sdk.models.request.feeandcharge.ChargeFeeBodyReqDebitAccount;
import com.ncb.sdk.models.request.feeandcharge.ChargeFeeCHGBodyReq;
import com.ncb.sdk.models.request.feeandcharge.ChargeFeeCHGRequest;
import com.ncb.sdk.models.request.header.HeaderRequest;
import com.ncb.sdk.models.response.fillter.AuthenInfo;
import com.ncb.sdk.services.IFeeAndChargeService;
import com.ncb.sdk.services.IFillterKeyService;
import com.ncb.sdk.infrastructure.common.AppConfig;
import com.ncb.sdk.infrastructure.common.AppConstants;
import com.ncb.sdk.utils.GetBaseHeader;
import com.ncb.sdk.utils.UnirestUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FeeAndChargeServiceImpl implements IFeeAndChargeService {
    private LogHelper logHelper = new LogHelper(FeeAndChargeServiceImpl.class);
    private ResponseUtility responseUtility = new ResponseUtility(CustomerServiceImpl.class);
    private UnirestUtil unirestUtil;
    private IFillterKeyService fillterKeyService;
    private GetBaseHeader getBaseHeader;

    public FeeAndChargeServiceImpl() {
        unirestUtil = new UnirestUtil();
        fillterKeyService = new FillterKeyServiceImpl();
        getBaseHeader = new GetBaseHeader();
    }


    @Override
    public BaseResponse ChargeFeeCHG(AuthenInfo authenInfo) {
        try{
            HashMap<String, String> header = fillterKeyService.process(authenInfo);
            if(Objects.isNull(header)) {
                return responseUtility.unauthorizedException("Unauthorized", FeeAndChargeServiceEnum.FEE_AND_CHARGE_UNAUTHORZIRED.getValue());
            }

            ChargeFeeCHGRequest chargeFeeCHGRequest = new ChargeFeeCHGRequest();
            HeaderRequest headerRequest = getBaseHeader.getHeader();
            chargeFeeCHGRequest.setHeader(headerRequest);
            ChargeFeeCHGBodyReq bodyReq = new ChargeFeeCHGBodyReq();
            bodyReq.setFunctionCode(AppConstants.CHARGE_FEE_CHG);
            bodyReq.setRequestType("BOOK");

            ChargeFeeBodyReqDebitAccount chargeFeeBodyReqDebitAccount = new ChargeFeeBodyReqDebitAccount();
            chargeFeeBodyReqDebitAccount.setAcctNo("100011594527");
            bodyReq.setDebitAccount(chargeFeeBodyReqDebitAccount);

            bodyReq.setChargeCcy("VND");
            bodyReq.setStatus("PAID");
            bodyReq.setLocalOfficer("9001");
            bodyReq.setChargeDetail("BNF");

            ChargeFeeBodyReqChargeCodes chargeFeeBodyReqChargeCodes = new ChargeFeeBodyReqChargeCodes();
            chargeFeeBodyReqChargeCodes.setChargeCode("GNND01002");
            chargeFeeBodyReqChargeCodes.setChargeAmount("80000");
            List<ChargeFeeBodyReqChargeCodes> listChargeFeeBodyReqChargeCodes = new ArrayList<>();
            listChargeFeeBodyReqChargeCodes.add(chargeFeeBodyReqChargeCodes);
            bodyReq.setChargeCodes(listChargeFeeBodyReqChargeCodes);

            List<String> listExtraDetails = new ArrayList<>();
            listExtraDetails.add("EXTRADETAILS  1");
            bodyReq.setExtraDetails(listExtraDetails);

            List<String> listFlexRefInfo = new ArrayList<>();
            listFlexRefInfo.add("232344");
            listFlexRefInfo.add("NGUYEN");
            listFlexRefInfo.add("TRAN");
            bodyReq.setFlexRefInfo(listFlexRefInfo);

            bodyReq.setCompany("VN0010001");

            chargeFeeCHGRequest.setBodyReq(bodyReq);

            BaseRequest baseRequest = new BaseRequest();
            baseRequest.setThuPhiCHGReq(chargeFeeCHGRequest);
            Gson gson = new Gson();
            String jsonString = gson.toJson(baseRequest);
            String chargeFeeCHGResponse = unirestUtil.post(AppConfig.IBMB_URL + AppConfig.CHARGE_FEE_CHG, header, jsonString);
            return responseUtility.successResponse(chargeFeeCHGResponse);
        }catch (Exception e) {
            logHelper.error(e, FeeAndChargeServiceEnum.FEE_AND_CHARGE_SERVICE_ENUM_1.getValue());
            return responseUtility.internalServerException("Internal Error", FeeAndChargeServiceEnum.FEE_AND_CHARGE_SERVICE_ENUM_1.getValue());
        }
    }

}
