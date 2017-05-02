package com.clteam.utils;

/**
 * Created by Dell on 29-Apr-17.
 */
public class ValidatorUtil {

    public static boolean isEmpty(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }
        return false;
    }

    public static long covertStringToId(String s) throws NumberFormatException {

        return Integer.parseInt(s);
    }
}
