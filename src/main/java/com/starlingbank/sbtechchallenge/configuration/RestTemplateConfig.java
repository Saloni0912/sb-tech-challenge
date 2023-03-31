package com.starlingbank.sbtechchallenge.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestTemplateConfig {

    @Value("${starling.api.auth.token}")
    private String authorizationToken;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(60000))
                .setReadTimeout(Duration.ofMillis(60000))
                .build();
    }

    @Bean(name="starlingApiRestTemplate")
    public RestTemplate starlingApiRestTemplate(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(60000);

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if(CollectionUtils.isEmpty(interceptors)){
         interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        }
        interceptors.add(new HttpClientRequestInterceptor(ACCEPT,APPLICATION_JSON_VALUE));
        interceptors.add(new HttpClientRequestInterceptor(CONTENT_TYPE,APPLICATION_JSON_VALUE));
        interceptors.add(new HttpClientRequestInterceptor(AUTHORIZATION,format("Bearer %s",authorizationToken)));
        restTemplate.setInterceptors(interceptors);

        return restTemplate;

    }
}
