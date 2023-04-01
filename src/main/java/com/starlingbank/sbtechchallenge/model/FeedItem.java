package com.starlingbank.sbtechchallenge.model;

public class FeedItem {
    public FeedItem() {
    }

    public FeedItem(String feedItemUid, String categoryUid, Amount amount, String direction) {
        this.feedItemUid = feedItemUid;
        this.categoryUid = categoryUid;
        this.amount = amount;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "FeedItem{" +
                "feedItemUid='" + feedItemUid + '\'' +
                ", categoryUid='" + categoryUid + '\'' +
                ", amount=" + amount +
                ", sourceAmount=" + sourceAmount +
                ", direction='" + direction + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", transactionTime='" + transactionTime + '\'' +
                ", settlementTime='" + settlementTime + '\'' +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", counterPartyType='" + counterPartyType + '\'' +
                ", counterPartyName='" + counterPartyName + '\'' +
                ", counterPartySubEntityName='" + counterPartySubEntityName + '\'' +
                ", counterPartySubEntityIdentifier='" + counterPartySubEntityIdentifier + '\'' +
                ", counterPartySubEntitySubIdentifier='" + counterPartySubEntitySubIdentifier + '\'' +
                ", reference='" + reference + '\'' +
                ", country='" + country + '\'' +
                ", spendingCategory='" + spendingCategory + '\'' +
                ", hasAttachment=" + hasAttachment +
                ", hasReceipt=" + hasReceipt +
                ", batchPaymentDetails=" + batchPaymentDetails +
                ", transactingApplicationUserUid='" + transactingApplicationUserUid + '\'' +
                ", counterPartyUid='" + counterPartyUid + '\'' +
                ", counterPartySubEntityUid='" + counterPartySubEntityUid + '\'' +
                '}';
    }


    private String feedItemUid;
    private String categoryUid;
    private Amount amount;
    private SourceAmount sourceAmount;
    private String direction;
    private String updatedAt;
    private String transactionTime;
    private String settlementTime;
    private String source;
    private String status;
    private String counterPartyType;
    private String counterPartyName;
    private String counterPartySubEntityName;
    private String counterPartySubEntityIdentifier;
    private String counterPartySubEntitySubIdentifier;
    private String reference;
    private String country;
    private String spendingCategory;
    private Boolean hasAttachment;
    private Boolean hasReceipt;
    private Object batchPaymentDetails;
    private String transactingApplicationUserUid;
    private String counterPartyUid;
    private String counterPartySubEntityUid;

    public String getFeedItemUid() {
        return feedItemUid;
    }

    public String getCategoryUid() {
        return categoryUid;
    }

    public Amount getAmount() {
        return amount;
    }

    public SourceAmount getSourceAmount() {
        return sourceAmount;
    }

    public String getDirection() {
        return direction;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public String getSettlementTime() {
        return settlementTime;
    }

    public String getSource() {
        return source;
    }

    public String getStatus() {
        return status;
    }

    public String getCounterPartyType() {
        return counterPartyType;
    }

    public String getCounterPartyName() {
        return counterPartyName;
    }

    public String getCounterPartySubEntityName() {
        return counterPartySubEntityName;
    }

    public String getCounterPartySubEntityIdentifier() {
        return counterPartySubEntityIdentifier;
    }

    public String getCounterPartySubEntitySubIdentifier() {
        return counterPartySubEntitySubIdentifier;
    }

    public String getReference() {
        return reference;
    }

    public String getCountry() {
        return country;
    }

    public String getSpendingCategory() {
        return spendingCategory;
    }

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public Boolean getHasReceipt() {
        return hasReceipt;
    }

    public Object getBatchPaymentDetails() {
        return batchPaymentDetails;
    }

    public String getTransactingApplicationUserUid() {
        return transactingApplicationUserUid;
    }

    public String getCounterPartyUid() {
        return counterPartyUid;
    }

    public String getCounterPartySubEntityUid() {
        return counterPartySubEntityUid;
    }

}
