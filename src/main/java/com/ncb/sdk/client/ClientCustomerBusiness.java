package com.ncb.sdk.client;
import com.ncb.sdk.facade.Facade;
import com.ncb.sdk.infrastructure.response.BaseResponse;

public class ClientCustomerBusiness {
    public BaseResponse getAccountInfo(String id){
        System.out.println("ClientBusiness Start getAccountInfo");
//        return Facade.getInstance().getAccountInfo(id);
        return null;
    }

    public BaseResponse testException(String id){
        System.out.println("ClientBusiness Start getAccountInfo");
//        return Facade.getInstance().testException(id);
        return null;
    }
}
