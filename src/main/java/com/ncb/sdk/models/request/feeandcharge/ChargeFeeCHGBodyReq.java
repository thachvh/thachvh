package com.ncb.sdk.models.request.feeandcharge;

import com.ncb.sdk.models.request.transfer.TransferToSBVBodyReqCreditAccount;
import com.ncb.sdk.models.request.transfer.TransferToSBVBodyReqDebitAccount;
import lombok.Data;

import java.util.List;

@Data
public class ChargeFeeCHGBodyReq {
    public String functionCode;
    public String requestType;
    public ChargeFeeBodyReqDebitAccount debitAccount;
    public String chargeCcy;
    public String status;
    public String localOfficer;
    public String chargeDetail;
    public List<ChargeFeeBodyReqChargeCodes> chargeCodes;
    public List<String> extraDetails;
    public List<String> flexRefInfo;
    public String company;
}
