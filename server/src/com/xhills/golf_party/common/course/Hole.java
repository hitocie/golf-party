package com.xhills.golf_party.common.course;

import java.io.Serializable;

public class Hole implements Serializable {

    private static final long serialVersionUID = 1L;

    private int no;
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public int getPar() {
        return par;
    }
    public void setPar(int par) {
        this.par = par;
    }
    public int getBackYard() {
        return backYard;
    }
    public void setBackYard(int backYard) {
        this.backYard = backYard;
    }
    public int getWhiteYard() {
        return whiteYard;
    }
    public void setWhiteYard(int whiteYard) {
        this.whiteYard = whiteYard;
    }
    public int getRedYard() {
        return redYard;
    }
    public void setRedYard(int redYard) {
        this.redYard = redYard;
    }
    public int getHandicap() {
        return handicap;
    }
    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }
    private int par;
    private int backYard;
    private int whiteYard;
    private int redYard;
    private int handicap;

}
