package com.starlingbank.sbtechchallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starlingbank.sbtechchallenge.model.Account;
import com.starlingbank.sbtechchallenge.model.Accounts;
import com.starlingbank.sbtechchallenge.service.AccountsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountsController.class)
class AccountsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountsService accountsService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getAccounts() throws Exception {
        Account account = new Account();
        account.setAccountUid(UUID.fromString("6bc18c45-b84e-4cb9-96dd-c1fffea848f4"));

        Accounts accounts = new Accounts();
        accounts.setAccounts(Collections.singletonList(account));

        Mockito.when(accountsService.fetchAccountsFromApi()).thenReturn(accounts);

        mockMvc.perform(get("/accounts")
                        .contentType(APPLICATION_JSON_VALUE))
                                .andExpect(status().isOk())
                                        .andExpect(content().json(
                                                """
                                                        {
                                                          "accounts": [
                                                            {
                                                              "accountUid": "6bc18c45-b84e-4cb9-96dd-c1fffea848f4"
                                                            }
                                                          ]
                                                        }
                                                        """.trim())
                                        );

    }


}