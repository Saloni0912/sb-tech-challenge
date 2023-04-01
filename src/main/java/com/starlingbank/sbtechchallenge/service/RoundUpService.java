package com.starlingbank.sbtechchallenge.service;

import com.starlingbank.sbtechchallenge.model.Accounts;
import com.starlingbank.sbtechchallenge.model.Amount;
import com.starlingbank.sbtechchallenge.model.FeedItems;
import com.starlingbank.sbtechchallenge.model.SavingGoalResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

/*
This Service class orchestrates other services to fetch accounts, transactions,
calculate rounded up value and sends the amount to SavingsGoalService.
 */
@Service
public class RoundUpService {

    private final Logger logger = LoggerFactory.getLogger(RoundUpService.class);

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private SavingsGoalService savingsGoalService;

    public Amount calculateAmount(OffsetDateTime minTransactionTimestamp, OffsetDateTime maxTransactionTimestamp){
        Accounts accounts = accountsService.fetchAccountsFromApi();
        UUID accountUid = accounts.getAccounts().get(0).getAccountUid();
        UUID categoryUid = accounts.getAccounts().get(0).getDefaultCategory();

        FeedItems feedItems = transactionsService.fetchTransactions(accountUid, categoryUid, minTransactionTimestamp, maxTransactionTimestamp);
        int roundUpValue = feedItems.getFeedItems().stream()
                .filter(feedItem -> feedItem.getDirection().equalsIgnoreCase("OUT"))
                .mapToInt(feedItem -> feedItem.getAmount().getMinorUnits())
                .filter(amount -> amount >= 0)
                .map(amount -> 100 - amount % 100)
                .filter(amount -> amount != 100)
                .sum();
        String currency = feedItems.getFeedItems().get(0).getAmount().getCurrency();
        logger.info("For accountUid {} the roundUpValue is {} in currency {}",accountUid,roundUpValue,currency);
        return new Amount(currency,roundUpValue);

    }

    public SavingGoalResponse putAmountIntoSavingGoal(UUID accountUid, UUID savingGoalUid, OffsetDateTime minTransactionTimestamp, OffsetDateTime maxTransactionTimestamp){
        Amount savingAmount = calculateAmount(minTransactionTimestamp, maxTransactionTimestamp);
        return savingsGoalService.putAmountIntoSavingsGoal(accountUid, savingGoalUid, savingAmount);
    }


}
