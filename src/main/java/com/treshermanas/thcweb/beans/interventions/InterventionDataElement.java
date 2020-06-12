package com.treshermanas.thcweb.beans.interventions;

public class InterventionDataElement {

    private Integer smsCount    = 0;
    private Integer callsCount  = 0;
    private Integer visitsCount = 0;

    public InterventionDataElement(Integer smsCount, Integer callsCount, Integer visitsCount){
        this.smsCount = smsCount;
        this.callsCount = callsCount;
        this.visitsCount = visitsCount;
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }

    public Integer getCallsCount() {
        return callsCount;
    }

    public void setCallsCount(Integer callsCount) {
        this.callsCount = callsCount;
    }

    public Integer getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(Integer visitsCount) {
        this.visitsCount = visitsCount;
    }

}
