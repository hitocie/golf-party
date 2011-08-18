package com.xhills.golf_party.model.sample;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;
import com.xhills.golf_party.meta.sample.HogeMeta;

@Model(schemaVersion = 1)
public class Foo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String name;
    private long age;
    private long lastHogeId = 0L;
    
    

    // Hoge‚Ö‚Ì1‘Î‘½‚ÌŠÖ˜A 
    @Attribute(persistent=false)
    private InverseModelListRef<Hoge, Foo> hogeRef =
        new InverseModelListRef<Hoge, Foo>(Hoge.class, HogeMeta.get().fooRef, this);
    
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
        Foo other = (Foo) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getAge() {
        return age;
    }
    public void setAge(long age) {
        this.age = age;
    }

    public InverseModelListRef<Hoge, Foo> getHogeRef() {
        return hogeRef;
    }
//
//    public void setHogeRef(InverseModelListRef<Hoge, Foo> hogeRef) {
//        this.hogeRef = hogeRef;
//    }

    public long getLastHogeId() {
        return lastHogeId;
    }

    public void setLastHogeId(long lastHogeId) {
        this.lastHogeId = lastHogeId;
    }
    
}
