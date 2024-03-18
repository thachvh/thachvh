package com.ncb.sdk.utils;

import com.ncb.sdk.models.request.header.HeaderClient;
import com.ncb.sdk.models.request.header.HeaderCommon;
import com.ncb.sdk.models.request.header.HeaderRequest;
import com.ncb.sdk.models.request.header.HeaderClientUserDetail;

import java.time.Instant;

public class GetBaseHeader {
    public HeaderRequest getHeader(){
        HeaderCommon headerCommon = new HeaderCommon();
        headerCommon.setServiceVersion("1");
        headerCommon.setMessageId("1111");
        headerCommon.setTransactionId("1111");
        headerCommon.setMessageTimestamp(Instant.now().toString());
        HeaderClient headerClient = new HeaderClient();
        HeaderClientUserDetail userDetail = new HeaderClientUserDetail();
        userDetail.setUserID("MB");
        userDetail.setUserPassword("RUJBTksxMjM=");
        headerClient.setSourceAppID("MB");
        headerClient.setTargetAppIDs("T24");
        headerClient.setUserDetail(userDetail);

        HeaderRequest headerRequest = new HeaderRequest();
        headerRequest.setCommon(headerCommon);
        headerRequest.setClient(headerClient);

        return headerRequest;

    }
}
