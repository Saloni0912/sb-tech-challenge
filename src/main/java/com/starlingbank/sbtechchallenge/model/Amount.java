package com.starlingbank.sbtechchallenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "currency",
        "minorUnits"
})

public class Amount {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("minorUnits")
    private Integer minorUnits;

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("minorUnits")
    public Integer getMinorUnits() {
        return minorUnits;
    }

}
