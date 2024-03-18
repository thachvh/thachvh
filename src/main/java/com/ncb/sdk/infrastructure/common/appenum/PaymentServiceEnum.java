package com.ncb.sdk.infrastructure.common.appenum;

public enum PaymentServiceEnum {
    PAYMENT_UNAUTHORZIRED("0","NCB.SDK.000.004.001"),
    PAYMENT_SERVICE_ENUM_1("1","NCB.SDK.000.004.002"),
    PAYMENT_SERVICE_ENUM_2("2","NCB.SDK.000.004.003"),
    PAYMENT_SERVICE_ENUM_3("3","NCB.SDK.000.004.004"),
    PAYMENT_SERVICE_ENUM_4("4","NCB.SDK.000.004.005");

    private final String code;
    private final String value;

    PaymentServiceEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public static PaymentServiceEnum getByCode(String code) {
        for(PaymentServiceEnum e : values()) {
            if(e.code.equals(code)) return e;
        }
        return null;
    }
}
