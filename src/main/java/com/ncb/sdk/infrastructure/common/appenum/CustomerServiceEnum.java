package com.ncb.sdk.infrastructure.common.appenum;

public enum CustomerServiceEnum {
    CUSTOMER_UNAUTHORZIRED("0","NCB.SDK.000.002.001"),
    CUSTOMER_SERVICE_ENUM_1("1","NCB.SDK.000.002.002"),
    CUSTOMER_SERVICE_ENUM_2("2","NCB.SDK.000.002.003"),
    CUSTOMER_SERVICE_ENUM_3("3","NCB.SDK.000.002.004"),
    CUSTOMER_SERVICE_ENUM_4("4","NCB.SDK.000.002.005");

    private final String code;
    private final String value;

    CustomerServiceEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public static CustomerServiceEnum getByCode(String code) {
        for(CustomerServiceEnum e : values()) {
            if(e.code.equals(code)) return e;
        }
        return null;
    }
}
