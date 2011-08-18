package com.xhills.golf_party.service.sample;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.xhills.golf_party.meta.sample.FooMeta;
import com.xhills.golf_party.meta.sample.HogeMeta;
import com.xhills.golf_party.model.sample.Foo;
import com.xhills.golf_party.model.sample.Hoge;


public class FirstService {

    public List<Foo> getAll() {
        FooMeta m = FooMeta.get();
        return Datastore.query(m).sort(m.age.desc).asList();
    }
    
    public void insert(Foo foo, List<Hoge> hoges) throws Exception {

        foo.setKey(Datastore.allocateId(FooMeta.get()));
        
        for (Hoge hoge : hoges) {
            long newHogeId = foo.getLastHogeId() + 1L;
            Key hogeKey = Datastore.createKey(foo.getKey(), HogeMeta.get(), newHogeId);
            hoge.setKey(hogeKey);
            hoge.getFooRef().setModel(foo);
            foo.setLastHogeId(newHogeId);
        }
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, foo);
            Datastore.put(tx, hoges);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.commit();
            }
            throw e;
        }

        
    }
}
