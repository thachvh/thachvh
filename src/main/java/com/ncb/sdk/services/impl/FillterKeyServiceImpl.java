package com.ncb.sdk.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncb.sdk.infrastructure.common.AppConfig;
import com.ncb.sdk.infrastructure.common.AppConstants;
import com.ncb.sdk.infrastructure.common.appenum.CommonEnum;
import com.ncb.sdk.infrastructure.helper.LogHelper;
import com.ncb.sdk.models.response.fillter.AuthenInfo;
import com.ncb.sdk.models.response.fillter.GentokenResponse;
import com.ncb.sdk.services.IFillterKeyService;
import com.ncb.sdk.utils.*;

import java.util.HashMap;

public class FillterKeyServiceImpl implements IFillterKeyService {
    private LogHelper logHelper = new LogHelper(FillterKeyServiceImpl.class);
    private static final String BEARER = "Bearer ";
    private static final String BASIC = "Basic ";
    private UnirestUtil unirestUtil;
    private String token = "";
    private Long expiredTokenTime = null;

    @Override
        public HashMap<String, String> process(AuthenInfo authenInfo) {
        System.out.println("==================== START GET BASE HEADER ====================");
        long startTime = System.currentTimeMillis();

        HashMap<String, String> header = new HashMap<>();

        if (StringUtils.isBlank(token) || expiredTokenTime == null || (!StringUtils.isBlank(token) && expiredTokenTime != null && expiredTokenTime <= startTime)) {

            String authenKey = authenInfo.getPublicKey() + ":" + authenInfo.getSecretKey();
            String encodedText = Base64Util.encode(authenKey);
            String authorization = BASIC + encodedText;
            header.put(AppConstants.AUTHORIZATION,authorization);

            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("grant_type","client_credentials");
            try{
                String responseAuthString = unirestUtil.postWithParameter(AppConfig.GENERATE_TOKEN_URL, header, parameters);

                ObjectMapper mapper = new ObjectMapper();
                GentokenResponse responseAuth = mapper.readValue(responseAuthString, GentokenResponse.class);
                if(responseAuth!=null && "approved".equals(responseAuth.getStatus())){
                    long currentTime = System.currentTimeMillis();
                    expiredTokenTime = currentTime + Long.valueOf(responseAuth.getExpiresIn()) * 1000;
                    if("BearerToken".equals(responseAuth.getTokenType())){
                        token = BEARER + responseAuth.getAccessToken();
                    }
                }else{
                    return null;
                }
            }catch (Exception e){
                logHelper.error(e, CommonEnum.CommonEnumEnum1.getValue());
                return null;
            }
        }

        header.put(AppConstants.AUTHORIZATION, token);

        System.out.println("==================== END GET BASE HEADER ====================");
        return header;
    }

}