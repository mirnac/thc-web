package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.backingbeans.invoices.customer.Invoice;
import com.treshermanas.thcweb.backingbeans.invoices.customer.SearchOverdueInvoiceFilter;
import com.treshermanas.thcweb.exception.DataNotFoundException;
import com.treshermanas.thcweb.exception.ThcServiceException;
import com.treshermanas.thcweb.services.dto.PageDto;
import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.services.invoices.InvoicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoicesController {

    private final Logger logger = LoggerFactory.getLogger(InvoicesController.class);

    private final InvoicesService invoicesService;

    @Value("${dolibarr.url}")
    private String dolibarrBaseUrl;

    public InvoicesController(InvoicesService invoicesService) {
        this.invoicesService = invoicesService;
    }

    @RequestMapping(value = "/unpaid/report", method = RequestMethod.GET, produces="application/pdf")
    @ResponseBody
    public byte[] paymentsReport(@RequestParam("date") String date, Model model) {

        try {
                Resource recurso = invoicesService.getUnpaidInvoicesByMonthAndYear(date);
                return Base64.getDecoder().decode(recurso.getData());

        }catch (DataNotFoundException e){
            model.addAttribute("errorMessage", e.getLocalizedMessage());
            throw new ThcServiceException(e);
        }

    }
    @RequestMapping(value = "/overdue",method = RequestMethod.GET)
    public String getOverdueInvoices(SearchOverdueInvoiceFilter filter, Model model){
        try{

            List<Invoice> invoices = searchInvoices(filter);

            model.addAttribute("overdueInvoices", invoices);
            model.addAttribute("searchOverdueInvoiceFilter",filter);
            model.addAttribute("dolibarrBaseUrl",dolibarrBaseUrl);
            return "/invoices/overdue.html";

        }catch (Exception e){

            logger.error(String.format("Error trying to get overdue invoices for day",filter.getDay()));
            model.addAttribute("errorMessage", e.getLocalizedMessage());

            throw new ThcServiceException(e);
        }
    }

    private List<Invoice> searchInvoices(SearchOverdueInvoiceFilter filter){

        PageDto<Invoice> invoicePageDto =  invoicesService.getOverdueInvoices(filter);

        List<Invoice> invoices =  invoicePageDto.getData();
        if(invoices != null && invoices.size() > 0 )
            invoices.sort(Comparator.comparing(Invoice::getDueDate).reversed());

        return invoices;
    }
    @RequestMapping(value = "/overdue/report", method = RequestMethod.GET, produces="application/pdf")
    @ResponseBody
    public byte[] getOverdueInvoicesReport(@RequestParam("date") String date, Model model) {

        try {
            Resource recurso = invoicesService.getUnpaidInvoicesByMonthAndYear(date);
            return Base64.getDecoder().decode(recurso.getData());

        }catch (DataNotFoundException e){
            model.addAttribute("errorMessage", e.getLocalizedMessage());
            throw new ThcServiceException(e);
        }

    }


    @RequestMapping(value = "/{invoice_id}")
    public Invoice getInvoice(@PathVariable("invoice_id") Integer invoiceId, Model model){
        try{

            return invoicesService.getInvoice(invoiceId);

        }catch (DataNotFoundException e){

            logger.error(String.format("Invoice with id %d does not exist",invoiceId));
            model.addAttribute("errorMessage", e.getLocalizedMessage());

            throw new ThcServiceException(e);
        }
    }

    @RequestMapping("/overdue/go")
    public String gotoSearchOverdueInvoices(Model model){

        SearchOverdueInvoiceFilter filter =  new SearchOverdueInvoiceFilter();
        filter.setDay(LocalDate.now().getDayOfMonth());
        List<Invoice> invoices = searchInvoices(filter);

        model.addAttribute("overdueInvoices", invoices);
        model.addAttribute("searchOverdueInvoiceFilter", filter);

        return "/invoices/overdue.html";
    }
}
