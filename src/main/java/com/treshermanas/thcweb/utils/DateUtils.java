package com.treshermanas.thcweb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

    public static String WEB_MONTH_YEAR_FORMAT = "MM/yyyy";
    public static String WEB_DATE_FORMAT       = "dd/MM/yyyy";
    public static String API_MONTH_YEAR_FORMAT = "yyyyMM";
    public static String API_DATE_FORMAT       = "yyyyMMdd";

    public static Boolean isValidWebMonthYearFormat(String monthAndYear){

        SimpleDateFormat sdf = new SimpleDateFormat(WEB_MONTH_YEAR_FORMAT);
        try{
            sdf.parse(monthAndYear);
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static String changeDateFormat(String inputFormat, String outputFormat, String date) throws ParseException {

        SimpleDateFormat sdfInput = new SimpleDateFormat(inputFormat);
        SimpleDateFormat sdfOutput = new SimpleDateFormat(outputFormat);

        return sdfOutput.format(sdfInput.parse(date));

    }
}
