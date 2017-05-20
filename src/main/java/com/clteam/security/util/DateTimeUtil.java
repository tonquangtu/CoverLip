package com.clteam.security.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
public class DateTimeUtil {

    public static String DATE_PATTERN = "dd/MM/yyyy";

    public static Timestamp getCurrentTime() {
        return new Timestamp(new Date().getTime());
    }

    public static Timestamp convertDateToTimestamp(String inputDate) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        Date outputDate = null;
        try {
            outputDate = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            outputDate = new Date();
        }
        return new Timestamp(outputDate.getTime());
    }

}
