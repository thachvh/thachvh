package com.ncb.sdk.models.request.transfer;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class TransferToSBVRevRequest {
    public HeaderRequest header;
    public TransferToSBVRevBodyReq bodyReq;

}
