package com.starlingbank.sbtechchallenge.model;

import java.util.List;


public class Accounts {

    private List<Account> accounts;

    @Override
    public String toString() {
        return "Accounts{" +
                "accounts=" + accounts +
                '}';
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Accounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Accounts() {
    }


}
