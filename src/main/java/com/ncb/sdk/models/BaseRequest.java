package com.ncb.sdk.models;

import com.ncb.sdk.models.request.customer.GetCifByLegalRequest;
import com.ncb.sdk.models.request.customer.GetCustomerInfoByIdRequest;
import com.ncb.sdk.models.request.customer.GetSignatureByCifRequest;
import com.ncb.sdk.models.request.account.GetListAccountInfoByCustomerRequest;
import com.ncb.sdk.models.request.account.GetAccountInfoByIdRequest;
import com.ncb.sdk.models.request.feeandcharge.ChargeFeeCHGRequest;
import com.ncb.sdk.models.request.payment.PaymentByCashRequest;
import com.ncb.sdk.models.request.payment.PaymentByCashRevRequest;
import com.ncb.sdk.models.request.payment.PaymentByCashSeeRequest;
import com.ncb.sdk.models.request.transfer.GetFlexTransInfoByIdRequest;
import com.ncb.sdk.models.request.transfer.TransferToSBVRevRequest;
import com.ncb.sdk.models.request.transfer.TransferToSBVSeeRequest;
import com.ncb.sdk.models.request.transfer.TransferToSBVRequest;
import lombok.Data;

@Data
public class BaseRequest {
    public GetAccountInfoByIdRequest getAccountInfoByIdReq;
    public GetListAccountInfoByCustomerRequest getListAccountByCustomerReq;
    public GetCifByLegalRequest getCifByLegalReq;
    public GetCustomerInfoByIdRequest getCustomerInfoByIdReq;
    public GetSignatureByCifRequest getSignatureByCifReq;
    public PaymentByCashRequest thanhToanNopTienMatReq;
    public PaymentByCashRevRequest thanhToanNopTienMatRevReq   ;
    public PaymentByCashSeeRequest thanhToanNopTienMatSeeReq;
    public TransferToSBVRequest nopRutTienNHNNReq;
    public TransferToSBVRevRequest nopRutTienNHNNRevReq;
    public TransferToSBVSeeRequest nopRutTienNHNNSeeReq;
    public GetFlexTransInfoByIdRequest getFlexTransInfoByIdReq;
    public ChargeFeeCHGRequest thuPhiCHGReq;
}
