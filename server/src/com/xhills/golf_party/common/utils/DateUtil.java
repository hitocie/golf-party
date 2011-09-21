package com.xhills.golf_party.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static SimpleDateFormat formatter = 
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static String toString(Date date) {
        if (date == null)
            return null;
        return formatter.format(date);
    }
    
    public static Date toDate(String str) throws ParseException {
        if (str == null)
            return null;
        return formatter.parse(str);
    }

}
