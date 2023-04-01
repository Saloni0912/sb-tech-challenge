package com.starlingbank.sbtechchallenge.exception;

import org.springframework.http.HttpStatus;

public class ClientServiceException extends RuntimeException{

    private final HttpStatus status;


    public ClientServiceException(String errorMessage, HttpStatus status) {
        super(errorMessage);
        this.status = status;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
