package com.treshermanas.thcweb.services.stock;

import com.treshermanas.thcweb.beans.products.ProductStock;
import com.treshermanas.thcweb.beans.products.StockVerificationItem;
import com.treshermanas.thcweb.model.StockVerificationModel;
import com.treshermanas.thcweb.services.dto.PageDto;
import com.treshermanas.thcweb.services.dto.products.ProductStockDto;
import com.treshermanas.thcweb.services.dto.products.StockVerificationDto;
import com.treshermanas.thcweb.services.dto.products.StockVerificationItemDto;
import com.treshermanas.thcweb.services.stock.requests.ConfirmStockVerificationReq;
import com.treshermanas.thcweb.services.stock.requests.StockVerificationReq;
import com.treshermanas.thcweb.utils.DtoTranslator;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockVerificationServiceImpl implements StockVerificationService {

    @Value("${backend.base.url}")
    private String baseUrl;
    @Value("${thc.stock.verification.pageSize}")
    private Integer pageSize;

    private RestTemplate restTemplate;
    private ModelMapper modelMapper;

    public StockVerificationServiceImpl(RestTemplate restTemplate, ModelMapper modelMapper) {
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }


    @Override
    public Integer getPendingVerificationCount(Integer warehouse) {
        String url = baseUrl + GET_PENDING_COUNT_PATH;
        url = String.format(url, warehouse);
        return restTemplate.getForObject(url, Integer.class);
    }

    @Override
    public List<StockVerificationItem> pendingVerificationProducts(Integer warehouse, String product) {
        String url = baseUrl + GET_PENDING_VERIFICATION_PATH;
        url = String.format(url, warehouse, pageSize);
        if (product != null)
            url = url + "&name=" + product;

        PageDto<ProductStockDto> pendingPage = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<PageDto<ProductStockDto>>() {
                }).getBody();

        return getVerificationItemsFromPageDto(pendingPage);
    }

    @Override
    public StockVerificationModel startVerification(Integer warehouse, String userName, String product) {

        StockVerificationReq request = StockVerificationReq.Builder
                .builder(warehouse, userName)
                .withName(product)
                .withPageNumber(PAGE_NUMBER)
                .withPageSize(pageSize)
                .build();

        String url = baseUrl + POST_START_VERIFICATION_PATH;
        HttpEntity<StockVerificationReq> requestData = new HttpEntity<>(request);
        StockVerificationDto responseDto = restTemplate.postForObject(url, requestData, StockVerificationDto.class);

        StockVerificationModel responseModel = modelMapper.map(responseDto, StockVerificationModel.class);
        java.lang.reflect.Type type = new TypeToken<List<StockVerificationItem>>() {
        }.getType();
        responseModel.setItems(
                modelMapper.map(responseDto.getPage().getData(),
                        type)
        );
        return responseModel;
    }

    private List<StockVerificationItem> getVerificationItemsFromPageDto(PageDto<ProductStockDto> pageDto) {

        List<StockVerificationItem> verificationItems = new ArrayList<>();
        if (pageDto != null && pageDto.getTotalPagesCount() > 0)
            pageDto.getData().forEach(
                    ps -> verificationItems.add(new StockVerificationItem(
                            modelMapper.map(ps, ProductStock.class)
                    ))
            );

        return verificationItems;
    }

    @Override
    public void cancelVerification(String uuid) {
        String url = baseUrl + PATCH_VERIFICATION_CANCEL;
        url = String.format(url, uuid);
        restTemplate.exchange(url, HttpMethod.PATCH, null, Void.TYPE);
    }

    @Override
    public void saveVerification(String uuid, List<StockVerificationItem> items) {

        String url = baseUrl + PUT_VERIFICATION;

        ConfirmStockVerificationReq request = new ConfirmStockVerificationReq(uuid,
                DtoTranslator.convertListToDtoList(items, StockVerificationItemDto.class));
        HttpEntity<ConfirmStockVerificationReq> requestData = new HttpEntity<>(request);
        restTemplate.put(url, requestData);

    }
}
