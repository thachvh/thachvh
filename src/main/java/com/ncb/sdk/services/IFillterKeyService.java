package com.ncb.sdk.services;

import com.ncb.sdk.models.response.fillter.AuthenInfo;

import java.util.HashMap;

public interface IFillterKeyService {
    public HashMap<String, String> process(AuthenInfo authenInfo);
    
}
