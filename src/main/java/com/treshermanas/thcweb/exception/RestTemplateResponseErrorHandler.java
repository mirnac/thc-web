package com.treshermanas.thcweb.exception;

import com.treshermanas.thcweb.beans.ApiErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private List<HttpMessageConverter<?>> messageConverters = Arrays.asList(new MappingJackson2HttpMessageConverter());
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return (
                clientHttpResponse.getStatusCode().series() == CLIENT_ERROR
                        || clientHttpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

        ApiErrorDto errorDto = null;
        String errorMessage = "";

        HttpMessageConverterExtractor<ApiErrorDto> msgExtractor = new HttpMessageConverterExtractor<>(ApiErrorDto.class, messageConverters);
        try {

            errorDto = msgExtractor.extractData(clientHttpResponse);
            errorMessage = errorDto.getErrorMessage();

            log.error(errorDto.toString());

        } catch (Exception e) {
        }

        if (clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new DataNotFoundException(errorMessage);
        } else if (clientHttpResponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            throw new AuthenticationException(errorMessage);
        } else if (clientHttpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            throw new ThcServiceException(errorMessage);
        } else if (clientHttpResponse.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            throw new ThcServiceException(errorMessage);
        }

    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        this.handleError(response);
    }
}
