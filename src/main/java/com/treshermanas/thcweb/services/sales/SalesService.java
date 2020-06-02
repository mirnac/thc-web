package com.treshermanas.thcweb.services.sales;

import com.treshermanas.thcweb.services.dto.Resource;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface SalesService {

    String GET_PROMISSORY_NOTE_REPORT_URL = "/sales/{invoice_id}/promissory_note";
    String GET_TOTAL_SALES_BY_DATE_URL    = "/sales/total/date";

    Resource getPromissoryNoteReport(Integer invoiceId, LocalDate firstPayment);

    BigDecimal getTotalSalesByDate(LocalDate now);
}
