package com.ncb.sdk.models.request.header;

import lombok.Data;

@Data
public class HeaderRequest {
    public HeaderCommon common;
    public HeaderClient client;
}
