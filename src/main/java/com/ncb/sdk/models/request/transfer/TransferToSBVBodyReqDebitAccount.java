package com.ncb.sdk.models.request.transfer;

import lombok.Data;

@Data
public class TransferToSBVBodyReqDebitAccount {
    public String acctNo;
    public String currency;
    public String amount;
    public String valueDate;
}
