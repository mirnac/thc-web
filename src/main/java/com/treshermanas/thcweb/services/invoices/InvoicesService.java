package com.treshermanas.thcweb.services.invoices;

import com.treshermanas.thcweb.backingbeans.invoices.customer.Invoice;
import com.treshermanas.thcweb.services.dto.Resource;

public interface InvoicesService {

    String GET_UNPAID_INVOICES_REPORT_URL = "/customer/invoices/unpaid/report";
    String GET_INVOICE_URL                = "/customer/invoices/{invoice_id}";

    /**
     * Receives month and year in MM-yyyy format and retrieves  a report
     * containing de list of unpaid invoices (without any payment)
     * @param monthYear
     * @return
     */
    Resource getUnpaidInvoicesByMonthAndYear(String monthYear);
    Invoice getInvoice(Integer invoiceId);
}
