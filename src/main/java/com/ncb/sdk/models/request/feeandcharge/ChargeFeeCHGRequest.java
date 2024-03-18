package com.ncb.sdk.models.request.feeandcharge;

import com.ncb.sdk.models.request.header.HeaderRequest;
import lombok.Data;

@Data
public class ChargeFeeCHGRequest {
    public HeaderRequest header;
    public ChargeFeeCHGBodyReq bodyReq;
}
