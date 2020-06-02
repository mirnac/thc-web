package com.treshermanas.thcweb.services.payments;

import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Value("${backend.base.url}")
    private String baseUrl;
    private final RestTemplate restTemplate;

    public PaymentsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Resource getPaymentsReportByDate(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.API_DATE_FORMAT);
        String url = baseUrl +GET_PAYMENT_REPORT_URL;
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url)
                .queryParam("date", sdf.format(date));

        return restTemplate.getForObject(builder.toUriString(),Resource.class);
    }

    public BigDecimal getTotalPaidByDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        String url = baseUrl + GET_PAID_BY_DATE_URL;
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url)
                .queryParam("date", formatter.format(date));

        return restTemplate.getForObject(builder.toUriString(),BigDecimal.class);

    }
}
