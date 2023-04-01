package com.starlingbank.sbtechchallenge.service;

import com.starlingbank.sbtechchallenge.client.StarlingBankApiClient;
import com.starlingbank.sbtechchallenge.model.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    @Autowired
    private StarlingBankApiClient starlingBankApiClient;

    public Accounts fetchAccountsFromApi(){
        return starlingBankApiClient.fetchAccounts();
    }

}
