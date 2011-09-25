package com.xhills.golf_party.model.course;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.util.DateUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.xhills.golf_party.common.course.Half;

@Model(schemaVersion = 1)
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    
    /*-------------------------------------*/
    private long courseId;
    public long getCourseId() {
        return courseId;
    }
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
    
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    private String address;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    private Date timestamp;
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    @Attribute(lob=true)
    private List<Half> halfs;
    public List<Half> getHalfs() {
        return halfs;
    }
    public void setHalfs(List<Half> halfs) {
        this.halfs = halfs;
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
        Course other = (Course) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
    
    
    public JSONObject toJSONObject() throws JSONException {
        JSONArray halfs = new JSONArray();
        for (Half h : getHalfs()) {
            halfs.put(h.toJSONObject());
        }
        return new JSONObject()
        .put("id", courseId)
        .put("name", name)
        .put("address", address)
        .put("timestamp", DateUtil.toString(timestamp))
        .put("halfs", halfs);
    }
}
