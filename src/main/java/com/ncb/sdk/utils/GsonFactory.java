package com.ncb.sdk.utils;

import com.google.gson.Gson;

import java.util.Objects;

/**
 * @author beibsh4rk
 * @date 28/09/2022
 * @project IBS-Common
 * @package com.msb.ibs.common.factory
 */
public class GsonFactory {

    private GsonFactory() {}

    private static volatile Gson instance;

    public static Gson getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (Gson.class) {
                if (Objects.isNull(instance)) {
                    instance = new Gson();
                }
            }
        }
        // Do something after get instance ...
        return instance;
    }

}
