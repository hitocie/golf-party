package com.xhills.golf_party.service.course;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;
import com.xhills.golf_party.meta.course.CourseMeta;
import com.xhills.golf_party.model.course.Course;


public class CourseService {

    public List<Course> getAll() {
        CourseMeta m = CourseMeta.get();
        return Datastore.query(m).sort(m.name.desc).asList();
    }
    
    public Course getCourse(String name) {
        CourseMeta m = CourseMeta.get();
        return Datastore.query(m)
                .filter(m.name.equal(name))
                .asSingle();
    }

    public Course createCourse(Course course) throws Exception {
        
        course.setKey(Datastore.allocateId(CourseMeta.get()));
        course.setTimestamp(new Date());
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, course);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return course;
    }
    
    /*
    public void createCourse(
            Course course,
            List<Half> halfs,
            List<List<Hole>> halfHoles) throws Exception {
        
        course.setKey(Datastore.allocateId(CourseMeta.get()));
        course.setTimestamp((new Date()).getTime());
        
        for (int i = 0; i < halfs.size(); i++) {
            Half half = halfs.get(i);
            Key key = Datastore.createKey(course.getKey(), HalfMeta.get(), i + 1);
            half.setKey(key);
            half.getCourseRef().setModel(course);
            List<Hole> holes = halfHoles.get(i);
            for (int j = 0; j < holes.size(); j++) {
                Hole hole = holes.get(j);
                Key holeKey = Datastore.createKey(half.getKey(), HoleMeta.get(), j + 1);
                hole.setKey(holeKey);
                hole.getHalfRef().setModel(half);
            }
        }
        
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, course);
            Datastore.put(tx, halfs);
            for (List<Hole> holes : halfHoles)
                Datastore.put(tx, holes);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
    
    
    public void deleteCourse(Course course) throws Exception {
        
        Transaction tx = Datastore.beginTransaction();
        try {
            for (Half half : course.getHalfRef().getModelList()) {
                for (Hole hole : half.getHoleRef().getModelList()) { 
                    Datastore.delete(tx, hole.getKey());
                }
                Datastore.delete(tx, half.getKey());
            }
            Datastore.delete(tx, course.getKey());
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
    */
}
