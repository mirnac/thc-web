package com.treshermanas.thcweb.services.collections.interventions;

import com.treshermanas.thcweb.beans.DataSummary;
import com.treshermanas.thcweb.beans.interventions.InterventionDataElement;
import org.springframework.stereotype.Service;

@Service
public interface InterventionService {

     String GET_YEAR_INTERVENTION_SUMMARY = "/interventions/summary/{year}";
     String GET_MONTH_INTERVENTION_SUMMARY = "/interventions/summary/{year}/{month}";

     DataSummary<InterventionDataElement> getYearInterventionsSummary(Integer year);
     InterventionDataElement getMonthInterventionsSummary(Integer year, Integer month);
}
