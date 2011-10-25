package com.xhills.golf_party.service.me;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;
import com.xhills.golf_party.meta.me.GroupMeta;
import com.xhills.golf_party.model.me.Group;


public class GroupService {

    public List<Group> getMyGroups(String id) {
        GroupMeta m = GroupMeta.get();
        return Datastore.query(m)
                .filter(m.ownerid.equal(id))
                .sort(m.ownerid.desc)
                .asList();
    }

    public Group createGroup(Group group) throws Exception {

        group.setTimestamp(new Date());
        group.setKey(Datastore.allocateId(GroupMeta.get()));
        group.setGroupid(group.getKey().getId());

        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, group);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return group;
    }
    
    public Group getGroup(long id) {
        GroupMeta m = GroupMeta.get();
        return Datastore.query(m)
                .filter(m.groupid.equal(id))
                .asSingle();
    }

    public Group updateGroup(
            long id,
            String ownerid, 
            String name,
            Set<String> userids) throws Exception {
        
        Group group = getGroup(id);
        group.setOwnerid(ownerid);
        group.setName(name);
        group.setUserids(userids);
        group.setTimestamp(new Date());
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, group);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return group;
    }

    public void deleteGroup(long id) throws Exception {
        
        Group group = getGroup(id);
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.delete(tx, group.getKey());
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
