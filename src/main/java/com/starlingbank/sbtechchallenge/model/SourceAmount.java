package com.starlingbank.sbtechchallenge.model;

public class SourceAmount {

    private String currency;
    private Integer minorUnits;

    public String getCurrency() {
        return currency;
    }

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
