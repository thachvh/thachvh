package com.ncb.sdk.models.request.fillter;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class GentokenRequest {

    @JsonProperty("grant_type")
    private String grantType;
}
