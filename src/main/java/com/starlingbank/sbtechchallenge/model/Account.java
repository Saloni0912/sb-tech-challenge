package com.starlingbank.sbtechchallenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
    private String accountUid;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("defaultCategory")
    private String defaultCategory;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("name")
    private String name;


    @JsonProperty("accountUid")
    public String getAccountUid() {
        return accountUid;
    }

    @JsonProperty("accountType")
    public String getAccountType() {
        return accountType;
    }

    @JsonProperty("defaultCategory")
    public String getDefaultCategory() {
        return defaultCategory;
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




}
