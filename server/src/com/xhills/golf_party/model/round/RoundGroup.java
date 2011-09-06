package com.xhills.golf_party.model.round;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;
import com.xhills.golf_party.meta.round.RoundMemberMeta;

@Model(schemaVersion = 1)
public class RoundGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    
    //--------------------------------
    
    
    // Round‚Æ‚ÌŠÖ˜A
    private ModelRef<Round> roundRef = new ModelRef<Round>(Round.class);
    public ModelRef<Round> getRoundRef() {
        return roundRef;
    }
    
    
    // RoundMember‚Ö‚Ì1‘Î‘½‚ÌŠÖ˜A 
    @Attribute(persistent=false)
    private InverseModelListRef<RoundMember, RoundGroup> roundMemberRef =
        new InverseModelListRef<RoundMember, RoundGroup>(RoundMember.class, RoundMemberMeta.get().roundGroupRef, this);
    public InverseModelListRef<RoundMember, RoundGroup> getRoundMemberRef() {
        return roundMemberRef;
    }
    //--------------------------------
    
    
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
        RoundGroup other = (RoundGroup) obj;
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
