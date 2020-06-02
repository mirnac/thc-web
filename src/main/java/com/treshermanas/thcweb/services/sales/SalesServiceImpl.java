package com.treshermanas.thcweb.services.sales;

import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class SalesServiceImpl implements SalesService {

    @Value("${backend.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public SalesServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override
    public Resource getPromissoryNoteReport(Integer invoiceId, LocalDate firstPayment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateUtils.API_DATE_FORMAT);
        String url = baseUrl +  GET_PROMISSORY_NOTE_REPORT_URL ;

        UriComponents builder = UriComponentsBuilder
                .fromUriString(url)
                .queryParam("init_payment", firstPayment.format(formatter))
                .buildAndExpand(invoiceId);

        return restTemplate.getForObject(builder.toUriString(),Resource.class);

    }

    @Override
    public BigDecimal getTotalSalesByDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateUtils.API_DATE_FORMAT);
        String url = baseUrl +  GET_TOTAL_SALES_BY_DATE_URL ;

        UriComponents builder = UriComponentsBuilder
                .fromUriString(url)
                .queryParam("date", date.format(formatter))
                .build();

        return restTemplate.getForObject(builder.toUriString(),BigDecimal.class);
    }
}
