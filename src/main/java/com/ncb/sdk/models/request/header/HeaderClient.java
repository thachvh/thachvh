package com.ncb.sdk.models.request.header;

import lombok.Data;

@Data
public class HeaderClient {
    public String sourceAppID;
    public String targetAppIDs;
    public HeaderClientUserDetail userDetail;
}
