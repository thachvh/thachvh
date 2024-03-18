package com.ncb.sdk.client;

import com.ncb.sdk.facade.Facade;
import com.ncb.sdk.infrastructure.response.BaseResponse;

public class ClientMain {
    public static void main(String[] args){

//        AuthenInfo authenInfo = new AuthenInfo();
//        authenInfo.setPublicKey("wG4kgtRW2idDuK8QwzZkXFc7sGstgkuV4JGisOZhbLfgaQ9t");
//        authenInfo.setSecretKey("Fs2dAvAoDeaYWGmNHTsVfGPGUuAA4Xv7kM7vXsgSyXgqugNTCSupckb4THv6gIfq");

        System.out.println("--------------------------Step 1-------------------------");
        BaseResponse a = Facade.getInstance().getAccountInfo("160000805588");


        Facade.getInstance().initRegister("AZAZAJiOD32qBthDksnhPmhSPAMtm8AzwhvhisA9nRWCnrsc", "uP8upQS31VwP1z1aJqwnsds4JIc0U355oxAt9odkIGY3nVefUjLoqmSeq5vZMxez");
//        Facade.initRegister(null, null);
//        Facade.authenInfo.setPublicKey("wG4kgtRW2idDuK8QwzZkXFc7sGstgkuV4JGisOZhbLfgaQ9t");
//        Facade.authenInfo.setSecretKey("Fs2dAvAoDeaYWGmNHTsVfGPGUuAA4Xv7kM7vXsgSyXgqugNTCSupckb4THv6gIfq");

        System.out.println("--------------------------Step 2-------------------------");
        ClientAccountBusiness clientAccountBusiness = new ClientAccountBusiness();
        BaseResponse clientAccountBusinessResponse = clientAccountBusiness.getAccountInfo("160000805588");
        System.out.println(clientAccountBusinessResponse.getData());
        System.out.println("ClientBusiness End getAccountInfo");

        System.out.println("--------------------------Step 3-------------------------");
        ClientCustomerBusiness clientCustomerBusiness = new ClientCustomerBusiness();
        BaseResponse clientCustomerBusinessResponse = clientCustomerBusiness.getAccountInfo("160000805588");
        System.out.println(clientCustomerBusinessResponse);
        System.out.println("ClientBusiness End getAccountInfo");


        System.out.println("--------------------------Step 4 test Exception-------------------------");
        ClientCustomerBusiness clientCustomerBusinessException = new ClientCustomerBusiness();
        BaseResponse clientCustomerBusinessExceptionResponse = clientCustomerBusiness.testException("160000805588");
        System.out.println(clientCustomerBusinessExceptionResponse);
        System.out.println("testException End getAccountInfo");

    }
}
