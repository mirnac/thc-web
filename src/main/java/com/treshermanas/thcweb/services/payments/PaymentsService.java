package com.treshermanas.thcweb.services.payments;

import com.treshermanas.thcweb.services.dto.Resource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public interface PaymentsService {

    String GET_PAYMENT_REPORT_URL = "/payments/report";
    String GET_PAID_BY_DATE_URL = "/payments/total/date";

    Resource getPaymentsReportByDate(Date date);
    BigDecimal getTotalPaidByDate(LocalDate date);
}
