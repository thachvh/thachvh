package com.ncb.sdk.models.request.transfer;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class TransferToSBVSeeRequest {
    public HeaderRequest header;
    public TransferToSBVSeeBodyReq bodyReq;

}
