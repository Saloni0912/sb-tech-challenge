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
    public Amount() {
    }

    @Override
    public String toString() {
        return "Amount{" +
                "currency='" + currency + '\'' +
                ", minorUnits=" + minorUnits +
                '}';
    }

    public Amount(String currency, Integer minorUnits) {
        this.currency = currency;
        this.minorUnits = minorUnits;
    }

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

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setMinorUnits(Integer minorUnits) {
        this.minorUnits = minorUnits;
    }
}
