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
import com.xhills.golf_party.model.common.User;
import com.xhills.golf_party.model.round.Round;
import com.xhills.golf_party.model.round.RoundGroup;
import com.xhills.golf_party.model.round.RoundMember;


public class RoundService {

    public List<Round> getAllRounds() {
        RoundMeta m = RoundMeta.get();
        return Datastore.query(m).sort(m.date.desc).asList();
    }
    
    public List<Round> getMyRounds(User user) {
        RoundMemberMeta m = RoundMemberMeta.get();
        List<RoundMember> roundMembers = 
                Datastore.query(m)
                .filter(m.userRef.equal(user.getKey()))
                .asList();
        
        List<Round> rounds = new ArrayList<Round>();
        for (RoundMember rm : roundMembers) {
            rounds.add(rm.getRoundGroupRef().getModel().getRoundRef().getModel());
        }
        return rounds;
    }
    
    public Round getRound(long roundId) {
        RoundMeta m = RoundMeta.get();
        return Datastore.query(m)
                .filter(m.roundId.equal(roundId))
                .asSingle();
    }
    
    
    public Round createRound(Round round) throws Exception {
        
        round.setKey(Datastore.allocateId(RoundMeta.get()));
        round.setRoundId(round.getKey().getId());
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
                rm.setScores(new ArrayList<Score>());
                for (int k = 0; k < 18; k++)
                    rm.getScores().add(new Score());
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
            long roundId,
            int groupIdx,
            int memberIdx,
            int holeIdx,
            int score, 
            int putter) throws Exception {
        
        RoundMeta m = RoundMeta.get();
        Round round = Datastore.query(m)
                .filter(m.roundId.equal(roundId))
                .asSingle();
        RoundGroup rg = 
                round.getRoundGroupRef().getModelList().get(groupIdx);
        RoundMember rm = 
                rg.getRoundMemberRef().getModelList().get(memberIdx);
        
        List<Score> scores = rm.getScores();
        Score s = scores.get(holeIdx);
        s.setScore(score);
        s.setPutter(putter);

        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, rm);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    
    public void deleteRound(long roundId) throws Exception {

        Round round = getRound(roundId);
        
        Transaction tx = Datastore.beginTransaction();
        try {
            for (RoundGroup rg : round.getRoundGroupRef().getModelList()) {
                for (RoundMember rm : rg.getRoundMemberRef().getModelList()) { 
                    Datastore.delete(tx, rm.getKey());
                }
                Datastore.delete(tx, rg.getKey());
            }
            Datastore.delete(tx, round.getKey());
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
}
