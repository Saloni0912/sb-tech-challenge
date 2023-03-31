package com.starlingbank.sbtechchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "feedItemUid",
        "categoryUid",
        "amount",
        "sourceAmount",
        "direction",
        "updatedAt",
        "transactionTime",
        "settlementTime",
        "source",
        "status",
        "counterPartyType",
        "counterPartyName",
        "counterPartySubEntityName",
        "counterPartySubEntityIdentifier",
        "counterPartySubEntitySubIdentifier",
        "reference",
        "country",
        "spendingCategory",
        "hasAttachment",
        "hasReceipt",
        "batchPaymentDetails",
        "transactingApplicationUserUid",
        "counterPartyUid",
        "counterPartySubEntityUid"
})

public class FeedItem {

    @JsonProperty("feedItemUid")
    private String feedItemUid;
    @JsonProperty("categoryUid")
    private String categoryUid;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("sourceAmount")
    private SourceAmount sourceAmount;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("transactionTime")
    private String transactionTime;
    @JsonProperty("settlementTime")
    private String settlementTime;
    @JsonProperty("source")
    private String source;
    @JsonProperty("status")
    private String status;
    @JsonProperty("counterPartyType")
    private String counterPartyType;
    @JsonProperty("counterPartyName")
    private String counterPartyName;
    @JsonProperty("counterPartySubEntityName")
    private String counterPartySubEntityName;
    @JsonProperty("counterPartySubEntityIdentifier")
    private String counterPartySubEntityIdentifier;
    @JsonProperty("counterPartySubEntitySubIdentifier")
    private String counterPartySubEntitySubIdentifier;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("country")
    private String country;
    @JsonProperty("spendingCategory")
    private String spendingCategory;
    @JsonProperty("hasAttachment")
    private Boolean hasAttachment;
    @JsonProperty("hasReceipt")
    private Boolean hasReceipt;
    @JsonProperty("batchPaymentDetails")
    private Object batchPaymentDetails;
    @JsonProperty("transactingApplicationUserUid")
    private String transactingApplicationUserUid;
    @JsonProperty("counterPartyUid")
    private String counterPartyUid;
    @JsonProperty("counterPartySubEntityUid")
    private String counterPartySubEntityUid;

    @JsonProperty("feedItemUid")
    public String getFeedItemUid() {
        return feedItemUid;
    }

    @JsonProperty("categoryUid")
    public String getCategoryUid() {
        return categoryUid;
    }

    @JsonProperty("amount")
    public Amount getAmount() {
        return amount;
    }

    @JsonIgnore
    @JsonProperty("sourceAmount")
    public SourceAmount getSourceAmount() {
        return sourceAmount;
    }

    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("transactionTime")
    public String getTransactionTime() {
        return transactionTime;
    }

    @JsonProperty("settlementTime")
    public String getSettlementTime() {
        return settlementTime;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("counterPartyType")
    public String getCounterPartyType() {
        return counterPartyType;
    }

    @JsonProperty("counterPartyName")
    public String getCounterPartyName() {
        return counterPartyName;
    }

    @JsonProperty("counterPartySubEntityName")
    public String getCounterPartySubEntityName() {
        return counterPartySubEntityName;
    }

    @JsonProperty("counterPartySubEntityIdentifier")
    public String getCounterPartySubEntityIdentifier() {
        return counterPartySubEntityIdentifier;
    }

    @JsonProperty("counterPartySubEntitySubIdentifier")
    public String getCounterPartySubEntitySubIdentifier() {
        return counterPartySubEntitySubIdentifier;
    }

    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("spendingCategory")
    public String getSpendingCategory() {
        return spendingCategory;
    }

    @JsonProperty("hasAttachment")
    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    @JsonProperty("hasReceipt")
    public Boolean getHasReceipt() {
        return hasReceipt;
    }

    @JsonProperty("batchPaymentDetails")
    public Object getBatchPaymentDetails() {
        return batchPaymentDetails;
    }

    @JsonProperty("transactingApplicationUserUid")
    public String getTransactingApplicationUserUid() {
        return transactingApplicationUserUid;
    }

    @JsonProperty("counterPartyUid")
    public String getCounterPartyUid() {
        return counterPartyUid;
    }

    @JsonProperty("counterPartySubEntityUid")
    public String getCounterPartySubEntityUid() {
        return counterPartySubEntityUid;
    }

}
