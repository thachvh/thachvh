package com.ncb.sdk.models.request.account;

import lombok.Data;

@Data
public class GetListAccountInfoByCustomerBodyReq {
    public String functionCode;
    public String customer;

}
