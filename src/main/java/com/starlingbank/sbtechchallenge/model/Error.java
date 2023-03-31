package com.starlingbank.sbtechchallenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    @JsonProperty("message")
    private String message;

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }
}

