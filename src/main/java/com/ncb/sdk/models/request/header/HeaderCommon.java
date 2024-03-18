package com.ncb.sdk.models.request.header;

import lombok.Data;

@Data
public class HeaderCommon {
    public String serviceVersion;
    public String messageId;
    public String transactionId;
    public String messageTimestamp;
}
