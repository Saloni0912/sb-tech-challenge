package com.starlingbank.sbtechchallenge.model;

import java.util.UUID;

public class Account {

    private UUID accountUid;
    private String accountType;
    private UUID defaultCategory;
    private String currency;
    private String createdAt;
    private String name;

    public Account(UUID accountUid, String accountType, UUID defaultCategory, String currency, String createdAt, String name) {
        this.accountUid = accountUid;
        this.accountType = accountType;
        this.defaultCategory = defaultCategory;
        this.currency = currency;
        this.createdAt = createdAt;
        this.name = name;
    }

    public Account() {
    }

    public UUID getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(UUID accountUid) {
        this.accountUid = accountUid;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public UUID getDefaultCategory() {
        return defaultCategory;
    }

    public void setDefaultCategory(UUID defaultCategory) {
        this.defaultCategory = defaultCategory;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountUid=" + accountUid +
                ", accountType='" + accountType + '\'' +
                ", defaultCategory=" + defaultCategory +
                ", currency='" + currency + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
