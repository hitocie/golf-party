package com.xhills.golf_party.model.course;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Hole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /*-------------------------------------*/
    private int no;
    private int par;
    private int backYard;
    private int whiteYard;
    private int redYard;
    private int handicap;
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
    // Half�Ƃ̊֘A
    private ModelRef<Half> halfRef = new ModelRef<Half>(Half.class);
    public ModelRef<Half> getHalfRef() {
        return halfRef;
    }
    /*-------------------------------------*/

    
    
    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Hole other = (Hole) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
