package com.treshermanas.thcweb.services.sales;

import com.treshermanas.thcweb.services.dto.Resource;

import java.time.LocalDate;

public interface SalesService {

    String GET_PROMISSORY_NOTE_REPORT_URL = "/sales/{invoice_id}/promissory_note";

    Resource getPromissoryNoteReport(Integer invoiceId, LocalDate firstPayment);
}
