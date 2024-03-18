package com.ncb.sdk.infrastructure.common;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    public static final String GENERATE_TOKEN_URL;
    public static final String IBMB_URL;
    public static final String GET_ACCOUNT_INFO_BY_ID;
    public static final String GET_LIST_ACCOUNT_BY_CUSTOMER;
    public static final String GET_CIF_BY_LEGAL;
    public static final String GET_CUSTOMER_INFO_BY_ID;
    public static final String GET_SIGNATURE_BY_CIF;
    public static final String PAYMENT_BY_CASH;
    public static final String PAYMENT_BY_CASH_REV;
    public static final String PAYMENT_BY_CASH_SEE;
    public static final String TRANSFER_TO_SBV;
    public static final String TRANSFER_TO_SBV_REV;
    public static final String TRANSFER_TO_SBV_SEE;
    public static final String GET_FLEX_TRANS_INFO_BY_ID;
    public static final String CHARGE_FEE_CHG;

    static {
        Properties prop = new Properties();
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("application-nbc-sdk.properties")) {
            prop.load(input);
            IBMB_URL = prop.getProperty("ibmb.url.domain");
            GET_ACCOUNT_INFO_BY_ID = prop.getProperty("getAccountInfoById");
            GET_LIST_ACCOUNT_BY_CUSTOMER = prop.getProperty("getListAccountByCustomer");
            GET_CIF_BY_LEGAL = prop.getProperty("getCifByLegal");
            GET_CUSTOMER_INFO_BY_ID = prop.getProperty("getCustomerInfoById");
            GET_SIGNATURE_BY_CIF = prop.getProperty("getSignatureByCif");
            PAYMENT_BY_CASH = prop.getProperty("paymentByCash");
            PAYMENT_BY_CASH_REV = prop.getProperty("paymentByCashRev");
            PAYMENT_BY_CASH_SEE = prop.getProperty("paymentByCashSee");
            TRANSFER_TO_SBV = prop.getProperty("transferToSBV");
            TRANSFER_TO_SBV_REV = prop.getProperty("transferToSBVRev");
            TRANSFER_TO_SBV_SEE = prop.getProperty("transferToSBVSee");
            GET_FLEX_TRANS_INFO_BY_ID = prop.getProperty("getFlexTransInfoById");
            CHARGE_FEE_CHG = prop.getProperty("chargeFeeCHG");
            GENERATE_TOKEN_URL = prop.getProperty("generateToken") ;
        } catch (Exception e) {
            throw new RuntimeException("Error loading configuration properties", e);
        }
    }
}
