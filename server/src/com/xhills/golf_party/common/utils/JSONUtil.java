package com.xhills.golf_party.common.utils;

import java.io.IOException;
import java.io.InputStream;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class JSONUtil {


    public static JSONObject inputStreamToJSONObject(InputStream in) throws JSONException, IOException {
        StringBuffer buf = new StringBuffer();
        int ch;
        while ((ch = in.read()) != -1) {
            buf.append((char) ch);
        }
        in.close();
        return new JSONObject(buf.toString());
    }
}
