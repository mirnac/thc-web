package com.treshermanas.thcweb.services.payments;

import com.treshermanas.thcweb.services.dto.Resource;

import java.util.Date;

public interface PaymentsService {

    String GET_PAYMENT_REPORT_URL = "/payments/report";

    Resource getPaymentsReportByDate(Date date);
}
