package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.exception.DataNotFoundException;
import com.treshermanas.thcweb.exception.ThcServiceException;
import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.services.invoices.InvoicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Base64;

@Controller
@RequestMapping("/invoices")
public class InvoicesController {

    private final Logger logger = LoggerFactory.getLogger(InvoicesController.class);

    private final InvoicesService invoicesService;

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

}
