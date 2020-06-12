package com.treshermanas.thcweb.services.collections.interventions;

import com.treshermanas.thcweb.beans.DataSummary;
import com.treshermanas.thcweb.beans.interventions.InterventionDataElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class InterventionServiceImpl implements  InterventionService {

    @Value("${backend.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public InterventionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public DataSummary<InterventionDataElement> getYearInterventionsSummary(Integer year) {
        String url = baseUrl +  GET_YEAR_INTERVENTION_SUMMARY ;

        UriComponents builder = UriComponentsBuilder
                .fromUriString(url)
                .buildAndExpand(year);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<DataSummary<InterventionDataElement>>() {}).getBody();
    }

    @Override
    public InterventionDataElement getMonthInterventionsSummary(Integer year, Integer month) {
        String url = baseUrl +  GET_MONTH_INTERVENTION_SUMMARY ;

        UriComponents builder = UriComponentsBuilder
                .fromUriString(url)
                 .buildAndExpand(year,month);

        return restTemplate.getForObject(builder.toUriString(),InterventionDataElement.class);
    }
}
