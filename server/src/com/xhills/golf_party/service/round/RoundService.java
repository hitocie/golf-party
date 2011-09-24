package com.xhills.golf_party.service.round;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.xhills.golf_party.common.round.Score;
import com.xhills.golf_party.meta.round.RoundGroupMeta;
import com.xhills.golf_party.meta.round.RoundMemberMeta;
import com.xhills.golf_party.meta.round.RoundMeta;
import com.xhills.golf_party.model.round.Round;
import com.xhills.golf_party.model.round.RoundGroup;
import com.xhills.golf_party.model.round.RoundMember;


public class RoundService {

    public List<Round> getAll() {
        RoundMeta m = RoundMeta.get();
        return Datastore.query(m).sort(m.date.desc).asList();
    }
    
    public Round createRound(Round round) throws Exception {
        
        round.setKey(Datastore.allocateId(RoundMeta.get()));
        round.setTimestamp(new Date());
        
        List<RoundGroup> roundGroups = round.getRoundGroupRef().getModelList();
        List<List<RoundMember>> roundMembers = new ArrayList<List<RoundMember>>();
        for (int i = 0; i < roundGroups.size(); i++) {
            RoundGroup rg = roundGroups.get(i);
            Key key = Datastore.createKey(round.getKey(), RoundGroupMeta.get(), i + 1);
            rg.setKey(key);
            //rg.getRoundRef().setModel(round);
            List<RoundMember> rms = rg.getRoundMemberRef().getModelList(); 
            for (int j = 0; j < rms.size(); j++) {
                RoundMember rm = rms.get(j);
                Key rmKey = Datastore.createKey(rg.getKey(), RoundMemberMeta.get(), j + 1);
                rm.setKey(rmKey);
                //rm.getRoundGroupRef().setModel(rg);
            }
            roundMembers.add(rms);
        }
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, round);
            Datastore.put(tx, roundGroups);
            for (List<RoundMember> rms : roundMembers)
                Datastore.put(tx, rms);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return round;
    }
    
    public void updateScore(
            Key rKey,
            int group_idx,
            int member_idx,
            int hole_idx,
            int score, 
            int putter) throws Exception {
        
        RoundMeta m = RoundMeta.get();
        Round round = Datastore.query(m)
                .filter(m.key.equal(rKey)).asSingle();
        RoundGroup rg = round.getRoundGroupRef().getModelList().get(group_idx);
        RoundMember rm = rg.getRoundMemberRef().getModelList().get(member_idx);
        Score s = rm.getScores().get(hole_idx);
        s.setScore(score);
        s.setPutter(putter);
    }

    /*
    public void createRound(
            Round round,
            List<RoundGroup> roundGroups,
            List<List<RoundMember>> roundMembers,
            List<List<List<Score>>> scores
    ) throws Exception {
        
        round.setKey(Datastore.allocateId(RoundMeta.get()));
        
        for (int i = 0; i < roundGroups.size(); i++) {
            RoundGroup rg = roundGroups.get(i);
            Key key = Datastore.createKey(round.getKey(), RoundGroupMeta.get(), i + 1);
            rg.setKey(key);
            rg.getRoundRef().setModel(round);
            List<RoundMember> rms = roundMembers.get(i);

            for (int j = 0; j < rms.size(); j++) {
                RoundMember rm = rms.get(j);
                Key rmKey = Datastore.createKey(rg.getKey(), RoundMemberMeta.get(), j + 1);
                rm.setKey(rmKey);
                rm.getRoundGroupRef().setModel(rg);
                List<Score> ss = scores.get(i).get(j);

                for (int k = 0; k < ss.size(); k++) {
                    Score s = ss.get(k);
                    Key sKey = Datastore.createKey(rm.getKey(), ScoreMeta.get(), k + 1);
                    s.setKey(sKey);
                    s.getRoundMemberRef().setModel(rm);
                }
            }
        }
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, round);
            Datastore.put(tx, roundGroups);
            for (List<RoundMember> rms : roundMembers)
                Datastore.put(tx, rms);
            for (List<List<Score>> ss : scores)
                for (List<Score> s : ss)
                    Datastore.put(tx, s);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }*/
}
