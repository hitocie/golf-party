package com.xhills.golf_party.service.common;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;
import com.xhills.golf_party.meta.common.UserMeta;
import com.xhills.golf_party.model.common.User;


public class UserService {
    
    public List<User> getAll() {
        UserMeta m = UserMeta.get();
        return Datastore.query(m).sort(m.name.desc).asList();
    }
    
    public User getUser(String id) {
        UserMeta m = UserMeta.get();
        return Datastore.query(m)
                .filter(m.id.equal(id))
                .asSingle();
    }

    public User createUser(User user) throws Exception {
        
        user.setKey(Datastore.allocateId(UserMeta.get()));
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, user);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return user;
    }
}
