package com.xhills.golf_party.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class JSONUtil {


    public static JSONObject inputStreamToJSONObject(InputStream in) throws JSONException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuffer buf = new StringBuffer();
        int ch;
        while ((ch = reader.read()) != -1) {
            buf.append((char) ch);
        }
        reader.close();
        return new JSONObject(buf.toString());
    }
}
