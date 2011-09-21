package com.xhills.golf_party.common.course;

import java.io.Serializable;
import java.util.List;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class Half implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private List<Hole> holes;
    public List<Hole> getHoles() {
        return holes;
    }
    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }
    
    
    public JSONObject toJSONObject() throws JSONException {
        JSONArray holes = new JSONArray();
        for (Hole h : getHoles()) 
            holes.put(h.toJSONObject());
        
        return new JSONObject()
        .put("name", name)
        .put("holes", holes);
    }
}
