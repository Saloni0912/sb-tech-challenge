package com.starlingbank.sbtechchallenge.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starlingbank.sbtechchallenge.model.Accounts;
import com.starlingbank.sbtechchallenge.model.Amount;
import com.starlingbank.sbtechchallenge.model.FeedItems;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;

import static java.time.OffsetDateTime.now;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RoundUpServiceTest {

    @MockBean
    private AccountsService accountsService;

    @MockBean
    private TransactionsService transactionsService;

    @MockBean
    private SavingsGoalService savingsGoalService;

    @Autowired
    private RoundUpService roundUpService;

    @Autowired
    private ObjectMapper mapper;

    OffsetDateTime minTransactionTimestamp = now();
    OffsetDateTime maxTransactionTimestamp = now();


    @Test
    void calculateAmountTest() throws IOException {
        Accounts accounts = mapper.readValue(new File("src/test/resources/accounts.json"),Accounts.class);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(accounts));

        FeedItems feedItems = mapper.readValue(new File("src/test/resources/weekly_transaction_feeds.json"),FeedItems.class);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(feedItems));

        Mockito.when(accountsService.fetchAccountsFromApi()).thenReturn(accounts);
        Mockito.when(transactionsService.fetchTransactions(any(),any(),any(),any())).thenReturn(feedItems);

        Amount amount = roundUpService.calculateAmount(minTransactionTimestamp,maxTransactionTimestamp);
        assertNotNull(amount.getMinorUnits());
        assertNotEquals(0,amount.getMinorUnits());
        assertNotNull(amount.getCurrency());

    }

}