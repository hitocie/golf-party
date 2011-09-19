package com.xhills.golf_party.model.round;

import java.io.Serializable;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;
import com.xhills.golf_party.common.round.Score;
import com.xhills.golf_party.model.common.User;

@Model(schemaVersion = 1)
public class RoundMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    
    
    //------------------------
    
    // Userへの1対1の関連（外部キー）
    private ModelRef<User> userRef = new ModelRef<User>(User.class);
    public ModelRef<User> getUserRef() {
        return userRef;
    }
    
    // RoundGroupとの関連
    private ModelRef<RoundGroup> roundGroupRef = new ModelRef<RoundGroup>(RoundGroup.class);
    public ModelRef<RoundGroup> getRoundGroupRef() {
        return roundGroupRef;
    }
    
//    // Scoreへの1対多の関連 
//    @Attribute(persistent=false)
//    private InverseModelListRef<Score, RoundMember> scoreRef =
//        new InverseModelListRef<Score, RoundMember>(Score.class, ScoreMeta.get().roundMemberRef, this);
//    public InverseModelListRef<Score, RoundMember> getScoreRef() {
//        return scoreRef;
//    }
    @Attribute(lob=true)
    private List<Score> scores;
    public List<Score> getScores() {
        return scores;
    }
    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
    //------------------------
    
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
        RoundMember other = (RoundMember) obj;
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
