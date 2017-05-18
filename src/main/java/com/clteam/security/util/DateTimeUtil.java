package com.clteam.security.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
public class DateTimeUtil {

    public static Timestamp getCurrentTime() {
        return new Timestamp(new Date().getTime());
    }

}
