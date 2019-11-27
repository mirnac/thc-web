package com.treshermanas.thcweb.services.stock;

import com.treshermanas.thcweb.beans.products.StockVerificationItem;
import com.treshermanas.thcweb.model.StockVerificationModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StockVerificationServiceImplTest {

    @Autowired
    private StockVerificationService stockVerificationService;

    @Test
    void getPendingVerificationCount() {
        Integer count = stockVerificationService.getPendingVerificationCount(1);
        assertNotNull(count);
    }

    @Test
    void pendingVerificationProducts() {

        List<StockVerificationItem> items = stockVerificationService.pendingVerificationProducts(1,null);
        assertNotNull(items);
        assertTrue(items.size() > 0);
    }

    @Test
    void startVerification() {

        StockVerificationModel model =
                stockVerificationService.startVerification(1,"mirnac",null);

        assertNotNull(model);
        assertNotNull(model.getItems());
        assertNotNull(model.getUuid());

    }

    @Test
    void cancelVerification() {
        StockVerificationModel model =
                stockVerificationService.startVerification(1,"mirnac",null);
        stockVerificationService.cancelVerification(model.getUuid());
    }
}