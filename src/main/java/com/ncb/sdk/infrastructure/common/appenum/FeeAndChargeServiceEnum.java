package com.ncb.sdk.infrastructure.common.appenum;

public enum FeeAndChargeServiceEnum {
    FEE_AND_CHARGE_UNAUTHORZIRED("0","NCB.SDK.000.004.001"),
    FEE_AND_CHARGE_SERVICE_ENUM_1("1","NCB.SDK.000.004.002"),
    FEE_AND_CHARGE_SERVICE_ENUM_2("2","NCB.SDK.000.004.003"),
    FEE_AND_CHARGE_SERVICE_ENUM_3("3","NCB.SDK.000.004.004"),
    FEE_AND_CHARGE_SERVICE_ENUM_4("4","NCB.SDK.000.004.005");

    private final String code;
    private final String value;

    FeeAndChargeServiceEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public static FeeAndChargeServiceEnum getByCode(String code) {
        for(FeeAndChargeServiceEnum e : values()) {
            if(e.code.equals(code)) return e;
        }
        return null;
    }
}
