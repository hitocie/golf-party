package com.xhills.golf_party.service.course;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.xhills.golf_party.meta.course.CourseMeta;
import com.xhills.golf_party.meta.course.HalfMeta;
import com.xhills.golf_party.meta.course.HoleMeta;
import com.xhills.golf_party.model.course.Course;
import com.xhills.golf_party.model.course.Half;
import com.xhills.golf_party.model.course.Hole;


public class CourseService {

    public List<Course> getAll() {
        CourseMeta m = CourseMeta.get();
        return Datastore.query(m).sort(m.name.desc).asList();
    }

    public void insert(
            Course course,
            List<Half> halfs,
            List<List<Hole>> halfHoles) throws Exception {
        
        course.setKey(Datastore.allocateId(CourseMeta.get()));
        course.setTimestamp((new Date()).getTime());
        
        for (int i = 0; i < halfs.size(); i++) {
            Half half = halfs.get(i);
            Key key = Datastore.createKey(course.getKey(), HalfMeta.get(), i);
            half.setKey(key);
            half.getCourseRef().setModel(course);
            List<Hole> holes = halfHoles.get(i);
            for (int j = 0; j < holes.size(); j++) {
                Hole hole = holes.get(j);
                Key holeKey = Datastore.createKey(half.getKey(), HoleMeta.get(), j);
                hole.setKey(holeKey);
                hole.getHalfRef().setModel(half);
            }
        }
        
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, course);
            Datastore.put(tx, halfs);
            Datastore.put(tx, halfHoles);
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
