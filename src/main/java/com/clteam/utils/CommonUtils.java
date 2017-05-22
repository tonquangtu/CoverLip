package com.clteam.utils;

/**
 * Created by Dell on 08-May-17.
 */
public class CommonUtils {


    public static String trimExcessWhiteSpace(String aString) {

        if (aString == null) {
            return null;
        }
        StringBuilder sContainer = new StringBuilder();
        aString = aString.trim();
        int length = aString.length();

        for(int i = 0; i < length; i++) {

            char c = aString.charAt(i);
            if (c != ' ') {
                sContainer.append(c);
            } else  {

                if (aString.charAt(i - 1) != ' ') {
                    sContainer.append(c);
                }
            }
        }
        return sContainer.toString();
    }

    public static String standardSearchString(String aString) {

        if (aString == null) {
            return null;
        }
        aString = trimExcessWhiteSpace(aString);
        aString = StringToEnglish.removeAccent(aString);
        return aString;
    }

    public static String[] splitString(String aString) {

        aString = standardSearchString(aString);
        if (aString != null) {
            return aString.split(" ");
        }
        return null;
    }

    public static String transformToSluxSearch(String aString) {

        aString = standardSearchString(aString);
        if (aString != null) {
            return aString.replaceAll(" ", "-");
        }
        return "";
    }
}
