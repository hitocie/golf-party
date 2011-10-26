package com.xhills.golf_party.model.me;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.util.DateUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

@Model(schemaVersion = 1)
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    
    //----------------------------
    private long groupid;
    public long getGroupid() {
        return groupid;
    }
    public void setGroupid(long groupid) {
        this.groupid = groupid;
    }
    
    private String ownerid; // User.userid
    public String getOwnerid() {
        return ownerid;
    }
    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }
   
    private String name; // group name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // TODO: image
    
    @Attribute(unindexed=true)
    private Set<String> userids; // friends
    public Set<String> getUserids() {
        return userids;
    }
    public void setUserids(Set<String> userids) {
        this.userids = userids;
    }
    
    private Date timestamp;
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    //----------------------------
    
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
        Group other = (Group) obj;
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
        JSONArray users = new JSONArray();
        for (String userid : userids) 
            users.put(userid);

        return new JSONObject()
        .put("id", groupid)
        .put("ownerid", ownerid)
        .put("name", name)
        .put("userids", users)
        .put("timestamp", DateUtil.toString(timestamp));
    }
}
