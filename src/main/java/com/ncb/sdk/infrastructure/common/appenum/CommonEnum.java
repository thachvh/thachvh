package com.ncb.sdk.infrastructure.common.appenum;

public enum CommonEnum {
    UNAUTHORZIRED("0","NCB.SDK.000.000.000"),
    CommonEnumEnum1("1","NCB.SDK.000.000.001"),
    CommonEnumEnum2("2","NCB.SDK.000.000.002"),
    CommonEnumEnum3("3","NCB.SDK.000.000.003"),
    CommonEnumEnum4("4","NCB.SDK.000.000.004");

    private final String code;
    private final String value;

    CommonEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public static CommonEnum getByCode(String code) {
        for(CommonEnum e : values()) {
            if(e.code.equals(code)) return e;
        }
        return null;
    }
}
