package com.starlingbank.sbtechchallenge.client;

import com.starlingbank.sbtechchallenge.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Service
public class StarlingBankApiClient {

    @Value("${starling.api.accountsUrl}")
    private String accountsUrl;

    @Value("${starling.api.transactionFeed}")
    private String transactionFeed;

    @Value("${starling.api.savingGoalUrl}")
    private String savingGoalUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Accounts fetchAccounts(){
        ResponseEntity<Accounts> accountsResponse = restTemplate.getForEntity(accountsUrl,Accounts.class);
        return accountsResponse.getBody();
    }

    public FeedItems fetchWeeklyTransactionFeeds(UUID accountUid, UUID categoryUid, OffsetDateTime minTransactionTimestamp, OffsetDateTime maxTransactionTimestamp ){
        Map<String,Object> accountDetails = new HashMap<>();
        accountDetails.put("accountUid",accountUid);
        accountDetails.put("categoryUid",categoryUid);

        String transactionFeedUrl = fromHttpUrl(transactionFeed)
                .queryParam("minTransactionTimestamp",minTransactionTimestamp.toString())
                .queryParam("maxTransactionTimestamp",maxTransactionTimestamp.toString())
                .buildAndExpand(accountDetails)
                .toUriString();

        ResponseEntity<FeedItems> transactionsResponse = restTemplate.getForEntity(transactionFeedUrl, FeedItems.class);
        return transactionsResponse.getBody();
    }

    public SavingGoalResponse putAmountIntoSavingGoal(UUID accountUid, UUID savingGoalUid, Amount amount){
        SavingGoalRequest savingGoalRequest = new SavingGoalRequest();
        savingGoalRequest.setAmount(amount);
        HttpEntity<SavingGoalRequest> requestEntity = new HttpEntity<>(savingGoalRequest);

        Map<String,Object> savingGoalDetails = new HashMap<>();
        savingGoalDetails.put("accountUid",accountUid.toString());
        savingGoalDetails.put("savingGoalUid",savingGoalUid.toString());
        savingGoalDetails.put("transferUid", randomUUID().toString());

        String putAmountIntoSavingGoalUrl = fromHttpUrl(savingGoalUrl)
                .buildAndExpand(savingGoalDetails)
                .toUriString();
        ResponseEntity<SavingGoalResponse> savingGoalResponse = restTemplate.exchange(putAmountIntoSavingGoalUrl, HttpMethod.PUT, requestEntity, SavingGoalResponse.class);
        return savingGoalResponse.getBody();
    }
}
