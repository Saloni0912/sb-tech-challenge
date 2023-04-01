package com.starlingbank.sbtechchallenge.controller;

import com.starlingbank.sbtechchallenge.model.Accounts;
import com.starlingbank.sbtechchallenge.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to Starling";
    }

    @GetMapping("/accounts")
    public Accounts getAccounts(){
        return accountsService.fetchAccountsFromApi();
    }
}
