package com.ncb.sdk.facade;

import com.ncb.sdk.infrastructure.helper.LogHelper;
import com.ncb.sdk.infrastructure.response.BaseResponse;
import com.ncb.sdk.models.response.fillter.AuthenInfo;
import com.ncb.sdk.services.IAccountService;
import com.ncb.sdk.services.impl.AccountServiceImpl;
import com.ncb.sdk.utils.TraceConfig;
import io.opentracing.Span;

public class Facade {
    private static final Facade INSTANCE = new Facade();
    private static final String publicKey = "";
    private static final String secretKey = "";
    private static final String privateKey = "";
    private final LogHelper logHelper = new LogHelper(Facade.class);
    private final AuthenInfo authenInfo = new AuthenInfo();
    private final IAccountService accountService;

    public Facade() {
        accountService = new AccountServiceImpl();
    }

    public static Facade getInstance() {
        return INSTANCE;
    }

    public void initRegister(String publicKey, String secretKey) {
        this.authenInfo.setPublicKey(publicKey);
        this.authenInfo.setSecretKey(secretKey);
    }

    public BaseResponse getAccountInfo(String id) {
        Span span = TraceConfig.createTrace("get_account_info");
        logHelper.info("getAccountInfo input --- id: " + id);
        try {
            BaseResponse responseGetAccountInfo = accountService.getAccountInfoById(authenInfo, id);
            System.out.println("End test call Api");
            return responseGetAccountInfo;// Xử lý yêu cầu
        } finally {
            TraceConfig.finishSpan(span);
        }
    }

    public BaseResponse testException(String id) {
        Span span = TraceConfig.createTrace("test_exception");
        logHelper.info("testException input --- id: " + id);
        try {
            BaseResponse responseGetAccountInfo = accountService.getListAccountInfoByCustomer(authenInfo, id);
            System.out.println("End test call Api");
            return responseGetAccountInfo;
        } finally {
            TraceConfig.finishSpan(span);
        }
    }
}
