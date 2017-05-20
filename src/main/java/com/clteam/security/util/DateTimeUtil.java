package com.clteam.security.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    public static String getRelativeDate(int num) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        if (num > 0) {
            localDate = localDate.plusDays(num);
        } else if (num < 0) {
            localDate = localDate.minusDays(-num);
        }
        return dtf.format(localDate);
    }

    public static String getNextDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now().plusDays(1);
        return dtf.format(localDate);
    }

}
