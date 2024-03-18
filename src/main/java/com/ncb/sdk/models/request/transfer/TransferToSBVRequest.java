package com.ncb.sdk.models.request.transfer;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class TransferToSBVRequest {
    public HeaderRequest header;
    public TransferToSBVBodyReq bodyReq;
}
