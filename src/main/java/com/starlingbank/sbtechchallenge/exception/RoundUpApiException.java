package com.starlingbank.sbtechchallenge.exception;

import org.springframework.http.HttpStatus;

public class RoundUpApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public RoundUpApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public RoundUpApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
