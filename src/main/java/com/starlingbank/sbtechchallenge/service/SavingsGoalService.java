package com.starlingbank.sbtechchallenge.service;

import com.starlingbank.sbtechchallenge.client.StarlingBankApiClient;
import com.starlingbank.sbtechchallenge.model.Amount;
import com.starlingbank.sbtechchallenge.model.SavingGoalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * This Service invokes Starling Bank API to save an amount
 * into savings goal.
 */
@Service
public class SavingsGoalService {

    @Autowired
    private StarlingBankApiClient starlingBankApiClient;

    public SavingGoalResponse putAmountIntoSavingsGoal(UUID accountUid, UUID savingGoalUid, Amount amount){
        return starlingBankApiClient.putAmountIntoSavingGoal(accountUid,savingGoalUid,amount);
    }
}
