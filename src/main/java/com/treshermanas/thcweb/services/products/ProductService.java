package com.treshermanas.thcweb.services.products;

import com.treshermanas.thcweb.backingbeans.SearchProductDetailsFilter;
import com.treshermanas.thcweb.beans.products.ProductDetail;
import com.treshermanas.thcweb.services.dto.PageDto;
import com.treshermanas.thcweb.services.dto.Resource;

public interface ProductService {

    PageDto<ProductDetail> searchProductsDetails(SearchProductDetailsFilter filter);
    Resource getBarcodesReport(SearchProductDetailsFilter filter);
}
