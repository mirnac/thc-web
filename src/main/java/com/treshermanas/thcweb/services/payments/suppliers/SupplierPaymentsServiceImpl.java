package com.treshermanas.thcweb.services.payments.suppliers;

import com.treshermanas.thcweb.beans.DataElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class SupplierPaymentsServiceImpl implements  SupplierPaymentsService {

    @Value("${backend.base.url}")
    private String baseUrl;
    private final RestTemplate restTemplate;

    public SupplierPaymentsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<DataElement> getMonthlyAmountPaymentSummary() {
        String url = baseUrl + GET_PAYMENT_SUMMARY_URL;
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url);

        return restTemplate.exchange(url,
                                            HttpMethod.GET,null,
                                                new ParameterizedTypeReference<List<DataElement>>(){}).getBody();
    }

}
