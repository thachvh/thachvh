package com.ncb.sdk.models.response.fillter;

import lombok.Data;

@Data
public class AuthenInfo {
    public String secretKey = "";
    public String publicKey = "";
    public String privateKey = "";
}
