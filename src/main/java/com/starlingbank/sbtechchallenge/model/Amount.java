package com.starlingbank.sbtechchallenge.model;

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
