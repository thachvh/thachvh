package com.ncb.sdk.infrastructure.common.appenum;

public enum AccountServiceEnum {
    ACCOUNT_UNAUTHORZIRED("0","NCB.SDK.000.001.001"),
    ACCOUNT_SERVICE_ENUM_1("1","NCB.SDK.000.001.002"),
    ACCOUNT_SERVICE_ENUM_2("2","NCB.SDK.000.001.003"),
    ACCOUNT_SERVICE_ENUM_3("3","NCB.SDK.000.001.004"),
    ACCOUNT_SERVICE_ENUM_4("4","NCB.SDK.000.001.005");

    private final String code;
    private final String value;

    AccountServiceEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public static AccountServiceEnum getByCode(String code) {
        for(AccountServiceEnum e : values()) {
            if(e.code.equals(code)) return e;
        }
        return null;
    }
}
