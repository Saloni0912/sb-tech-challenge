package com.starlingbank.sbtechchallenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "accountUid",
        "accountType",
        "defaultCategory",
        "currency",
        "createdAt",
        "name"
})

public class Account {

    @JsonProperty("accountUid")
    private UUID accountUid;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("defaultCategory")
    private UUID defaultCategory;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("name")
    private String name;


    @JsonProperty("accountType")
    public String getAccountType() {
        return accountType;
    }

    public UUID getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(UUID accountUid) {
        this.accountUid = accountUid;
    }

    public UUID getDefaultCategory() {
        return defaultCategory;
    }

    public void setDefaultCategory(UUID defaultCategory) {
        this.defaultCategory = defaultCategory;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }


    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }
}
