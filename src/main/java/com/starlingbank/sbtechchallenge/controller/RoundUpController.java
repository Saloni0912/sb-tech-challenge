package com.starlingbank.sbtechchallenge.controller;

import com.starlingbank.sbtechchallenge.model.SaveRoundUpRequest;
import com.starlingbank.sbtechchallenge.model.SavingGoalResponse;
import com.starlingbank.sbtechchallenge.service.RoundUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Controller calculates rounded up value for transactions
 * within given period and puts it into a saving goal.
 */
@RestController
public class RoundUpController {

    @Autowired
    private RoundUpService roundUpService;

    @PostMapping("/roundUp")
    public SavingGoalResponse saveRoundedUpValue(@RequestBody SaveRoundUpRequest request){
        return roundUpService.putAmountIntoSavingGoal(
                request.getAccountUid(),
                request.getSavingGoalUid(),
                request.getMinTransactionTimestamp(),
                request.getMaxTransactionTimestamp());
    }

}
