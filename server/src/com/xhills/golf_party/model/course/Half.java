package com.xhills.golf_party.model.course;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;
import com.xhills.golf_party.meta.course.HoleMeta;

@Model(schemaVersion = 1)
public class Half implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    

    /*-------------------------------------*/
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Course�Ƃ̊֘A
    private ModelRef<Course> courseRef = new ModelRef<Course>(Course.class);
    public ModelRef<Course> getCourseRef() {
        return courseRef;
    }

    // Hole�ւ�1�Α��̊֘A 
    @Attribute(persistent=false)
    private InverseModelListRef<Hole, Half> holeRef =
        new InverseModelListRef<Hole, Half>(Hole.class, HoleMeta.get().halfRef, this);
    public InverseModelListRef<Hole, Half> getHoleRef() {
        return holeRef;
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
        Half other = (Half) obj;
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
