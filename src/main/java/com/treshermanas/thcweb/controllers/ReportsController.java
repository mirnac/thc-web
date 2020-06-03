package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.reports.AmountSummary;
import com.treshermanas.thcweb.services.payments.customers.PaymentsService;
import com.treshermanas.thcweb.services.payments.suppliers.SupplierPaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private PaymentsService paymentsService;
    @Autowired
    private SupplierPaymentsService supplierPaymentsService;

    @RequestMapping(value = "/customers/payments/summary", method = RequestMethod.GET)
    @ResponseBody
    public List<AmountSummary> getMonthlyAmountPaidByCustomersSummary(){
        return paymentsService.getCustomersPaymentByMonth();
    }

    @RequestMapping(value = "/suppliers/payments/summary",method = RequestMethod.GET)
    @ResponseBody
    public List<AmountSummary> getMonthlyAmountPaidToSuppliers(){
        return supplierPaymentsService.getMonthlyAmountPaymentSummary();
    }
}
