package com.xhills.golf_party.common.round;

import java.io.Serializable;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class Score implements Serializable {

    private static final long serialVersionUID = 1L;
    

    private int score;
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    private int putter;
    public int getPutter() {
        return putter;
    }
    public void setPutter(int putter) {
        this.putter = putter;
    }

    
    // club;
    // fairway;
    // beach; // bool
    // penalty; // bool

    public JSONObject toJSONObject() throws JSONException {
        return new JSONObject()
        .put("score", score)
        .put("putter", putter);
    }
}
