package com.treshermanas.thcweb.services.thirdparty;

import com.treshermanas.thcweb.beans.thirdperson.Supplier;
import com.treshermanas.thcweb.services.dto.thirdparty.SupplierDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService {

    private static final String GET_SUPPLIERS_PATH = "/suppliers";

    @Value("${backend.base.url}")
    private String baseUrl;
    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;

    public ThirdPartyServiceImpl(RestTemplate restTemplate, ModelMapper modelMapper) {
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Supplier> getAllSuppliers() {

        String url = baseUrl + GET_SUPPLIERS_PATH;

        List<SupplierDto> suppliers = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<SupplierDto>>() {
                }).getBody();


        return modelMapper.map(suppliers,new TypeToken<List<Supplier>>(){}.getType());
    }
}
