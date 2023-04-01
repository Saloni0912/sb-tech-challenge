package com.starlingbank.sbtechchallenge.configuration;


import com.starlingbank.sbtechchallenge.exception.RestTemplateErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * This Configuration class creates RestTemplate Bean which sets http headers
 * and logs request and responses using Interceptors. We have also set
 * error handler in this class.
 */
@Configuration
public class RestTemplateConfig {

    @Value("${starling.api.auth.token}")
    private String authorizationToken;

    @Bean
    public RestTemplate restTemplate(){

        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if(CollectionUtils.isEmpty(interceptors)){
         interceptors = new ArrayList<>();
        }
        interceptors.add(new HttpClientRequestInterceptor(ACCEPT,APPLICATION_JSON_VALUE));
        interceptors.add(new HttpClientRequestInterceptor(CONTENT_TYPE,APPLICATION_JSON_VALUE));
        interceptors.add(new HttpClientRequestInterceptor(AUTHORIZATION,format("Bearer %s",authorizationToken)));
        interceptors.add(new RequestResponseLoggingInterceptor());
        restTemplate.setInterceptors(interceptors);


        restTemplate.setErrorHandler(new RestTemplateErrorHandler());

        return restTemplate;

    }
}
