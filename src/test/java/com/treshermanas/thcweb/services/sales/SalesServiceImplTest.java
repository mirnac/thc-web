package com.treshermanas.thcweb.services.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SalesServiceImplTest {

    @Autowired
    private SalesService salesService;

    @Test
    void getTotalSalesByDate() {
        BigDecimal total = salesService.getTotalSalesByDate(LocalDate.now().minusDays(1));
        assertNotNull(total);
        System.out.println(total.toPlainString());
    }
}