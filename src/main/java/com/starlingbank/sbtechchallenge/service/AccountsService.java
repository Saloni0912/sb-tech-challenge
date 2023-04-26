package com.starlingbank.sbtechchallenge.service;

import com.starlingbank.sbtechchallenge.client.StarlingBankApiClient;
import com.starlingbank.sbtechchallenge.exception.RoundUpApiException;
import com.starlingbank.sbtechchallenge.model.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * This class invokes Starling Bank API to fetch accounts.
 */
@Service
public class AccountsService {

    @Autowired
    private StarlingBankApiClient starlingBankApiClient;

    public Accounts fetchAccountsFromApi(){
        Accounts accounts = starlingBankApiClient.fetchAccounts();
        if(accounts == null){
            throw new RoundUpApiException(HttpStatus.INTERNAL_SERVER_ERROR,"Accounts details are emtpy");
        }
        return accounts;
    }

}
