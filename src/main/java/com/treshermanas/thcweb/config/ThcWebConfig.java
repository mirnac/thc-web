package com.treshermanas.thcweb.config;

import com.treshermanas.thcweb.exception.ExceptionMappingResolver;
import com.treshermanas.thcweb.exception.RestTemplateResponseErrorHandler;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.ClientHttpRequestFactorySupplier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Configuration
public class ThcWebConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        RestTemplate restTemplate = builder.requestFactory(new ClientHttpRequestFactorySupplier()).errorHandler(new RestTemplateResponseErrorHandler()).build();
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        return restTemplate;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ExceptionMappingResolver exceptionMappingResolver(){
        ExceptionMappingResolver mappingResolver =new ExceptionMappingResolver();
        mappingResolver.setDefaultErrorView("thc_error");
        return mappingResolver;
    }

}
