package com.starlingbank.sbtechchallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starlingbank.sbtechchallenge.model.SavingGoalResponse;
import com.starlingbank.sbtechchallenge.service.RoundUpService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.time.OffsetDateTime;

import static java.time.OffsetDateTime.now;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RoundUpController.class)
class RoundUpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoundUpService roundUpService;

    @Autowired
    private ObjectMapper mapper;

    OffsetDateTime minTransactionTimestamp = now();
    OffsetDateTime maxTransactionTimestamp = now();

    @Test
    void saveRoundedUpValue() throws Exception {
        SavingGoalResponse savingGoalResponse = mapper.readValue(new File("src/test/resources/saving_goal_response.json"),SavingGoalResponse.class);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(savingGoalResponse));

        Mockito.when(roundUpService.putAmountIntoSavingGoal(any(),any(),any(),any())).thenReturn(savingGoalResponse);

        mockMvc.perform(post("/roundUp").
                contentType(APPLICATION_JSON_VALUE).content(
                        """
                                {
                                  "accountUid": "9a38389c-17b8-4b46-89cd-2b88b10345c1",
                                  "savingGoalUid": "707613d3-96d5-49b8-9286-2af9782bfad6",
                                  "minTransactionTimestamp": "2023-03-28T20:31:30.010Z",
                                  "maxTransactionTimestamp": "2023-03-29T20:31:30.010Z"
                                }
                                """.trim()
                )).andExpect(status().isOk());


    }
}