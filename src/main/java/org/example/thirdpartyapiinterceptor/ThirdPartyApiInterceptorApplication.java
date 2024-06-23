package org.example.thirdpartyapiinterceptor;

import org.example.thirdpartyapiinterceptor.Interceptor.CustomClientHttpRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ThirdPartyApiInterceptorApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .additionalInterceptors(new CustomClientHttpRequestInterceptor())
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ThirdPartyApiInterceptorApplication.class, args);
    }

}
