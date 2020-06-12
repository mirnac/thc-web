package com.treshermanas.thcweb.beans;

import java.util.HashMap;
import java.util.Map;

public class DataSummary<T> {

    private Map<String, T> dataMap = new HashMap<>();

    public DataSummary(){

    }

    public Map<String, T> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, T> dataMap) {
        this.dataMap = dataMap;
    }
}
