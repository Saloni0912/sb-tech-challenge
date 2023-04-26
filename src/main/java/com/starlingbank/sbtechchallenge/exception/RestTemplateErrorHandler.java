package com.starlingbank.sbtechchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * This class handles error for RestTemplate
 */
@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if(response.getStatusCode().is4xxClientError()){
            if(response.getStatusCode() == HttpStatus.FORBIDDEN){
                throw new ClientServiceException("Forbidden to call the API",HttpStatus.FORBIDDEN);
            }
            if(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
                throw new ClientServiceException("Failed to call the API",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else if(response.getStatusCode().is5xxServerError()){
            if(response.getStatusCode() == HttpStatus.BAD_GATEWAY){
                throw new ClientServiceException("API failed to respond",HttpStatus.BAD_GATEWAY);
            }
        }


    }
}
