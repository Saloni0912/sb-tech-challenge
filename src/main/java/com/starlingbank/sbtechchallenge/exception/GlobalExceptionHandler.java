package com.starlingbank.sbtechchallenge.exception;

import com.starlingbank.sbtechchallenge.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    //handle specific exception
    @ExceptionHandler(ClientServiceException.class)
    public ResponseEntity<ErrorDetails> handleClientServiceException(ClientServiceException ex,
                                                                     WebRequest webRequest){
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
            webRequest.getDescription(false));
    return new ResponseEntity<>(errorDetails, ex.getStatus());
    }

    //handle specific exception
    @ExceptionHandler(RoundUpApiException.class)
    public ResponseEntity<ErrorDetails> handleRoundUpApiException(RoundUpApiException ex,
                                                                     WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    //handle global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleRoundUpApiException(Exception ex,
                                                                  WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
