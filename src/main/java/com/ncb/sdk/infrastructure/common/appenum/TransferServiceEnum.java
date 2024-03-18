package com.ncb.sdk.infrastructure.common.appenum;

public enum TransferServiceEnum {
    TRANSFER_UNAUTHORZIRED("0","NCB.SDK.000.003.001"),
    TRANSFER_SERVICE_ENUM_1("1","NCB.SDK.000.003.002"),
    TRANSFER_SERVICE_ENUM_2("2","NCB.SDK.000.003.003"),
    TRANSFER_SERVICE_ENUM_3("3","NCB.SDK.000.003.004"),
    TRANSFER_SERVICE_ENUM_4("4","NCB.SDK.000.003.005");

    private final String code;
    private final String value;

    TransferServiceEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public static TransferServiceEnum getByCode(String code) {
        for(TransferServiceEnum e : values()) {
            if(e.code.equals(code)) return e;
        }
        return null;
    }
}
