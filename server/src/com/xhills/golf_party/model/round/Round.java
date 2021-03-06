package com.xhills.golf_party.model.round;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.util.DateUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.xhills.golf_party.common.course.Half;
import com.xhills.golf_party.common.round.Weather;
import com.xhills.golf_party.common.round.Wind;
import com.xhills.golf_party.meta.round.RoundGroupMeta;
import com.xhills.golf_party.model.course.Course;

@Model(schemaVersion = 1)
public class Round implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    
    //------------------------------
    private long roundId;
    public long getRoundId() {
        return roundId;
    }
    public void setRoundId(long roundId) {
        this.roundId = roundId;
    }
    
    // Courseへの1対1の関連（外部キー）
    private ModelRef<Course> courseRef = new ModelRef<Course>(Course.class);
    public ModelRef<Course> getCourseRef() {
        return courseRef;
    }
    
    private Date date;
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    private Weather weather;
    public Weather getWeather() {
        return weather;
    }
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    private Wind wind;
    public Wind getWind() {
        return wind;
    }
    public void setWind(Wind wind) {
        this.wind = wind;
    }

//    // IN or OUT ...
//    private ModelRef<Half> firstHalfRef = new ModelRef<Half>(Half.class);
//    public ModelRef<Half> getFirstHalfRef() {
//        return firstHalfRef;
//    }
//    private ModelRef<Half> lastHalfRef = new ModelRef<Half>(Half.class);
//    public ModelRef<Half> getLastHalfRef() {
//        return lastHalfRef;
//    }
    @Attribute(lob=true)
    private List<Half> halfs;
    public List<Half> getHalfs() {
        return halfs;
    }
    public void setHalfs(List<Half> halfs) {
        this.halfs = halfs;
    }
    
    // RoundGroupへの1対多の関連 
    @Attribute(persistent=false)
    private InverseModelListRef<RoundGroup, Round> roundGroupRef =
        new InverseModelListRef<RoundGroup, Round>(RoundGroup.class, RoundGroupMeta.get().roundRef, this);
    public InverseModelListRef<RoundGroup, Round> getRoundGroupRef() {
        return roundGroupRef;
    }

    private Date timestamp;
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    //------------------------------
    
    
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
        Round other = (Round) obj;
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
        JSONArray roundGroups = new JSONArray();
        for (RoundGroup rg : roundGroupRef.getModelList()) 
            roundGroups.put(rg.toJSONObject());

        return new JSONObject()
        .put("id", roundId)
        .put("course", courseRef.getModel().toJSONObject())
        .put("date", DateUtil.toString(date))
        .put("weather", weather)
        .put("wind", wind)
        .put("groups", roundGroups)
        .put("timestamp", DateUtil.toString(timestamp));
    }
}
