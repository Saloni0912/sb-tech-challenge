package com.starlingbank.sbtechchallenge.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public class SaveRoundUpRequest {

    private UUID accountUid;
    private UUID savingGoalUid;
    private OffsetDateTime minTransactionTimestamp;
    private OffsetDateTime maxTransactionTimestamp;

    public SaveRoundUpRequest(UUID accountUid, UUID savingGoalUid, OffsetDateTime minTransactionTimestamp, OffsetDateTime maxTransactionTimestamp) {
        this.accountUid = accountUid;
        this.savingGoalUid = savingGoalUid;
        this.minTransactionTimestamp = minTransactionTimestamp;
        this.maxTransactionTimestamp = maxTransactionTimestamp;
    }

    public UUID getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(UUID accountUid) {
        this.accountUid = accountUid;
    }

    public UUID getSavingGoalUid() {
        return savingGoalUid;
    }

    public void setSavingGoalUid(UUID savingGoalUid) {
        this.savingGoalUid = savingGoalUid;
    }

    public OffsetDateTime getMinTransactionTimestamp() {
        return minTransactionTimestamp;
    }

    public void setMinTransactionTimestamp(OffsetDateTime minTransactionTimestamp) {
        this.minTransactionTimestamp = minTransactionTimestamp;
    }

    public OffsetDateTime getMaxTransactionTimestamp() {
        return maxTransactionTimestamp;
    }

    public void setMaxTransactionTimestamp(OffsetDateTime maxTransactionTimestamp) {
        this.maxTransactionTimestamp = maxTransactionTimestamp;
    }

    @Override
    public String toString() {
        return "SaveRoundUpRequest{" +
                "accountUid=" + accountUid +
                ", savingGoalUid=" + savingGoalUid +
                ", minTransactionTimestamp=" + minTransactionTimestamp +
                ", maxTransactionTimestamp=" + maxTransactionTimestamp +
                '}';
    }
}
