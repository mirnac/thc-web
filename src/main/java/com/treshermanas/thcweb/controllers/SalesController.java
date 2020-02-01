package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.backingbeans.invoices.customer.Invoice;
import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.services.invoices.InvoicesService;
import com.treshermanas.thcweb.services.sales.SalesService;
import com.treshermanas.thcweb.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Controller
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;
    private final InvoicesService invoicesService;

    public SalesController(SalesService salesService, InvoicesService invoicesService) {
        this.salesService = salesService;
        this.invoicesService = invoicesService;
    }

    @RequestMapping("/{invoice_id}/promissory_note/init")
    public String initPromissoryNote(@PathVariable("invoice_id") Integer invoiceId, Model model){

        Invoice invoice = invoicesService.getInvoice(invoiceId);
        invoice.setId(invoiceId);
        model.addAttribute("invoice",invoice);

        return "sales/pn_init";
    }

    @RequestMapping(value = "/promissory_note/report",method = RequestMethod.GET,produces = "application/pdf")
    @ResponseBody
    public byte[] printPromissoryNote(@RequestParam("invoice_id") Integer invoiceId, @RequestParam("first_payment") String firstPaymentDate){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateUtils.WEB_DATE_FORMAT);
        Resource resource = salesService.getPromissoryNoteReport(invoiceId, LocalDate.parse(firstPaymentDate, formatter));
        return Base64.getDecoder().decode(resource.getData());

    }

}
