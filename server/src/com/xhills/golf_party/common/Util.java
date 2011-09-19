package com.xhills.golf_party.common;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class Util {

    public static JSONObject inputStreamToJSONObject(InputStream in) throws JSONException, IOException {
        StringBuffer buf = new StringBuffer();
        int ch;
        while ((ch = in.read()) != -1) {
            buf.append((char) ch);
        }
        in.close();
        JSONObject obj = new JSONObject(buf.toString());
        return obj;
    }
    
    public static String dateToString(Date date) {
        if (date == null)
            return null;
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
    }

}
