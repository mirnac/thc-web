package com.treshermanas.thcweb.services.payments.suppliers;

import com.treshermanas.thcweb.beans.DataElement;

import java.util.List;


public interface SupplierPaymentsService {

    String GET_PAYMENT_SUMMARY_URL = "/suppliers/payments/summary";
    List<DataElement> getMonthlyAmountPaymentSummary();
}
