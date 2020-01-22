package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.exception.DataNotFoundException;
import com.treshermanas.thcweb.exception.ThcServiceException;
import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.services.payments.PaymentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;

@Controller
@RequestMapping("/payments")
public class PaymentsController {

    Logger logger = LoggerFactory.getLogger(PaymentsController.class);

    @Autowired
    private PaymentsService paymentsService;

    @RequestMapping(value = "/report", method = RequestMethod.GET, produces="application/pdf")
    @ResponseBody
    public byte[] paymentsReport(@RequestParam("date") String date, Model model) {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {

            Resource recurso = paymentsService.getPaymentsReportByDate(format.parse(date));
            return Base64.getDecoder().decode(recurso.getData());

        }catch (DataNotFoundException e){
            model.addAttribute("errorMessage", e.getLocalizedMessage());
            throw new ThcServiceException(e);
        } catch (ParseException e) {
          logger.error("Error",e);
          throw new ThcServiceException(e);
        }

    }

}
