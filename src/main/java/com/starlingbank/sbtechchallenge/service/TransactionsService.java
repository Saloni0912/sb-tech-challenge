package com.starlingbank.sbtechchallenge.service;

import com.starlingbank.sbtechchallenge.client.StarlingBankApiClient;
import com.starlingbank.sbtechchallenge.model.FeedItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class TransactionsService {

    @Autowired
    private StarlingBankApiClient starlingBankApiClient;

    public FeedItems fetchTransactions(UUID accountUid, UUID categoryUid, OffsetDateTime minTransactionTimestamp, OffsetDateTime maxTransactionTimestamp){
        return starlingBankApiClient.fetchWeeklyTransactionFeeds(accountUid,categoryUid,minTransactionTimestamp,maxTransactionTimestamp);
    }
}
