package com.ncb.sdk.models.request.transfer;

import lombok.Data;

import java.util.List;

@Data
public class TransferToSBVBodyReq {
    public String functionCode;
    public List<String> flexRefInfo;
    public TransferToSBVBodyReqDebitAccount debitAccount;
    public TransferToSBVBodyReqCreditAccount creditAccount;
    public String orderingCust;
    public String paymentDetails;
    public String profitCentreDept;
    public String company;
}
