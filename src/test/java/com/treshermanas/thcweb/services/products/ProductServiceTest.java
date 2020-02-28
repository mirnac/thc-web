package com.treshermanas.thcweb.services.products;

import com.treshermanas.thcweb.backingbeans.SearchProductDetailsFilter;
import com.treshermanas.thcweb.beans.products.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void searchProductsDetails() {
        LocalDate date = LocalDate.of(2020,2,24);

        SearchProductDetailsFilter filter = SearchProductDetailsFilter.builder().creationDate(date).build();

        List<ProductDetail> products = productService.searchProductsDetails(filter).getData();
        assertNotNull(products);
        assertTrue(products.size() > 0);
        assertNotNull(products.get(0).getProduct());
        assertNotNull(products.get(0).getSupplier());
        assertNotNull(products.get(0).getSupplierInvoice());
        assertNotNull(products.get(0).getCreated());
    }
}