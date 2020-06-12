package com.treshermanas.thcweb.services.payments.customers;

import com.treshermanas.thcweb.beans.DataElement;
import com.treshermanas.thcweb.services.dto.Resource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PaymentsService {

    String GET_PAYMENT_REPORT_URL  = "/payments/report";
    String GET_PAID_BY_DATE_URL    = "/payments/total/date";
    String GET_PAYMENT_SUMMARY_URL = "/payments/summary";

    Resource getPaymentsReportByDate(Date date);
    BigDecimal getTotalPaidByDate(LocalDate date);
    List<DataElement> getCustomersPaymentByMonth();
}
