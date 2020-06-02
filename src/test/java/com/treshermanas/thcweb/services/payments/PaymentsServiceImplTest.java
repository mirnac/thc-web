package com.treshermanas.thcweb.services.payments;

import com.treshermanas.thcweb.services.dto.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PaymentsServiceImplTest {

    @Autowired
    private PaymentsService paymentsService;

    @Test
    void getPaymentsReportByDate() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Resource resource =  paymentsService.getPaymentsReportByDate(sdf.parse("10/01/2020"));
        assertNotNull(resource);
        assertNotNull(resource.getData());
    }

    @Test
    void getTotalPaidByDate(){
        BigDecimal totalPaid = paymentsService.getTotalPaidByDate(LocalDate.now());
        assertNotNull(totalPaid);
        System.out.println(totalPaid);
    }
}