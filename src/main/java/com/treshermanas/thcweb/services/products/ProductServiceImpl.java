package com.treshermanas.thcweb.services.products;

import com.treshermanas.thcweb.backingbeans.SearchProductDetailsFilter;
import com.treshermanas.thcweb.beans.products.ProductDetail;
import com.treshermanas.thcweb.services.dto.PageDto;
import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.services.dto.products.ProductDetailDto;
import com.treshermanas.thcweb.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String SEARCH_PRODUCTS_DETAILS_PATH = "/products/details";
    private static final String GET_BARCODES_REPORT_PATH     = "/products/details/barcode/report";

    @Value("${backend.base.url}")
    private String baseUrl;
    @Value("${thc.products.barcode.pageSize}")
    private Integer pageSize;


    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(RestTemplate restTemplate, ModelMapper modelMapper) {
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }


    @Override
    public PageDto<ProductDetail> searchProductsDetails(SearchProductDetailsFilter filter) {

        String url = baseUrl +SEARCH_PRODUCTS_DETAILS_PATH;

        UriComponentsBuilder builder = getUriComponentsBuilderFromSearchFilter(filter,url);

         PageDto<ProductDetailDto> productsDtoPage =  restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
                null, new ParameterizedTypeReference<PageDto<ProductDetailDto>>() {
                }).getBody();

        java.lang.reflect.Type type = new TypeToken<List<ProductDetail>>() {}.getType();


         PageDto<ProductDetail> productsPage = new PageDto<>(productsDtoPage.getNumber(),productsDtoPage.getPageSize());
         productsPage.setTotalPagesCount(productsDtoPage.getTotalPagesCount());
         productsPage.setData(
                 modelMapper.map(productsDtoPage.getData(),type)
         );
        return productsPage;
    }

    @Override
    public Resource getBarcodesReport(SearchProductDetailsFilter filter) {

        String url = baseUrl + GET_BARCODES_REPORT_PATH;
        UriComponentsBuilder builder = getUriComponentsBuilderFromSearchFilter(filter,url);

        return restTemplate.getForObject(builder.toUriString(),Resource.class);
    }

    private UriComponentsBuilder getUriComponentsBuilderFromSearchFilter(SearchProductDetailsFilter filter, String url){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateUtils.API_DATE_FORMAT);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url);

        if(filter.getBarcode() != null && !filter.getBarcode().trim().equals(""))
            builder.queryParam("barcode", filter.getBarcode());

        if(filter.getProduct() != null && !filter.getProduct().trim().equals(""))
            builder.queryParam("productDescription",filter.getProduct());

        if(filter.getSupplierCode() != null && !filter.getSupplierCode().trim().equals(""))
            builder.queryParam("supplierCode",filter.getSupplierCode());

        if(filter.getCreationDate() != null)
            builder.queryParam("creationDate", filter.getCreationDate().format(formatter));

        if(filter.getInvoice() != null && !filter.getInvoice().trim().equals(""))
            builder.queryParam("invoice",filter.getInvoice());

        builder.queryParam("pageSize",pageSize)
                .queryParam("pageNumber",filter.getPageNumber());

       return builder;
    }
}
