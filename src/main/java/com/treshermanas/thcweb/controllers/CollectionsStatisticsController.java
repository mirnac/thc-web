package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.beans.interventions.InterventionDataElement;
import com.treshermanas.thcweb.services.collections.interventions.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/collections/statistics")
public class CollectionsStatisticsController {

    @Autowired
    private InterventionService interventionService;

    @RequestMapping(value={"/",""}, method = RequestMethod.GET)
    public String gotoStatisticsPage(Model model){

        LocalDate currentDate = LocalDate.now();

        InterventionDataElement data = interventionService.getMonthInterventionsSummary(currentDate.getYear(), currentDate.getMonthValue());

        model.addAttribute("smsCount", data.getSmsCount());
        model.addAttribute("intCount", data.getCallsCount()+data.getVisitsCount());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM yyyy",
                                                new Locale("es", "PY"));
        model.addAttribute("currentMonthYear", currentDate.format(fmt).toUpperCase());


        return "collections/statistics";
    }

    @RequestMapping(value = "/interventions/summary/year", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,InterventionDataElement> getYearInterventionsSummary(){
        LocalDate currentDate = LocalDate.now();
        return interventionService.getYearInterventionsSummary(currentDate.getYear()).getDataMap();
    }
}
