package com.treshermanas.thcweb.utils;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

class DateUtilsTest {

    @Test
    void changeDateFormat() throws ParseException {
        String changed = DateUtils.changeDateFormat(DateUtils.WEB_MONTH_YEAR_FORMAT, DateUtils.API_MONTH_YEAR_FORMAT,"12/2019");
        System.out.println(changed);
    }
}