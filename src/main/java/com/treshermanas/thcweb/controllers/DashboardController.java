package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.constants.DashBoardPerms;
import com.treshermanas.thcweb.services.payments.customers.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DashboardController {

    @Autowired
    private PaymentsService paymentsService;

    @RequestMapping(value = {"/index","/",""}, method = RequestMethod.GET)
    public String gotoDashboard(Model model){

        Map<String,Boolean> dashboardViewsPerms = new HashMap<>();

        dashboardViewsPerms.put(DashBoardPerms.TOTAL_RECEIVED_AMOUNT.name(), Boolean.TRUE);
        dashboardViewsPerms.put(DashBoardPerms.TOTAL_SALES_DAY_CHART.name(), Boolean.TRUE);
        dashboardViewsPerms.put(DashBoardPerms.MONTHLY_PAYMENTS_CHART.name(), Boolean.TRUE);

        model.addAttribute("dashboardPerms",dashboardViewsPerms);
        model.addAttribute("totalReceived",paymentsService.getTotalPaidByDate(LocalDate.now()));
        return "index";
    }

}
