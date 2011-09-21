package com.xhills.golf_party.common.course;

import java.io.Serializable;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class Hole implements Serializable {

    private static final long serialVersionUID = 1L;

    private int no;
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    
    private int par;
    public int getPar() {
        return par;
    }
    public void setPar(int par) {
        this.par = par;
    }
    
    private int backYard;
    public int getBackYard() {
        return backYard;
    }
    public void setBackYard(int backYard) {
        this.backYard = backYard;
    }

    private int whiteYard;
    public int getWhiteYard() {
        return whiteYard;
    }
    public void setWhiteYard(int whiteYard) {
        this.whiteYard = whiteYard;
    }
    
    private int redYard;
    public int getRedYard() {
        return redYard;
    }
    public void setRedYard(int redYard) {
        this.redYard = redYard;
    }

    private int handicap;
    public int getHandicap() {
        return handicap;
    }
    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }


    public JSONObject toJSONObject() throws JSONException {
        return new JSONObject()
        .put("no", no)
        .put("par", par)
        .put("back", backYard)
        .put("white", whiteYard)
        .put("red", redYard)
        .put("handicap", handicap);
    }

}
