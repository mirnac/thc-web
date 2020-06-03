package com.treshermanas.thcweb.services.payments.suppliers;

import com.treshermanas.thcweb.reports.AmountSummary;

import java.util.List;


public interface SupplierPaymentsService {

    String GET_PAYMENT_SUMMARY_URL = "/suppliers/payments/summary";
    List<AmountSummary> getMonthlyAmountPaymentSummary();
}
