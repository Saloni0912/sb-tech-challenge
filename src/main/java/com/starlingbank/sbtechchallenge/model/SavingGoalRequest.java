package com.starlingbank.sbtechchallenge.model;

public class SavingGoalRequest {

    private Amount amount;

    public SavingGoalRequest() {
    }

    public SavingGoalRequest(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "SavingGoalRequest{" +
                "amount=" + amount +
                '}';
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
