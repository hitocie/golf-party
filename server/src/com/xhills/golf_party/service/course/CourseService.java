package com.xhills.golf_party.service.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.FilterCriterion;

import com.google.appengine.api.datastore.Transaction;
import com.xhills.golf_party.meta.course.AreaMeta;
import com.xhills.golf_party.meta.course.CourseMeta;
import com.xhills.golf_party.model.course.Area;
import com.xhills.golf_party.model.course.Course;


public class CourseService {

    // Area
    public List<Area> getAllAreas() {
        AreaMeta m = AreaMeta.get();
        return Datastore.query(m).asList();
    }
    
    public Area getArea(String name) throws Exception {
        AreaMeta m = AreaMeta.get();
        Area area = Datastore.query(m)
                .filter(m.name.equal(name))
                .asSingle();
        if (area != null)
            return area;
     
        // if not exist, create new one.
        area = new Area();
        area.setName(name);
        area.setKey(Datastore.allocateId(AreaMeta.get()));
        
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, area);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return area;
    }
    
    
    // Course
    public List<Course> getAllCourses() {
        CourseMeta m = CourseMeta.get();
        return Datastore.query(m).sort(m.name.desc).asList();
    }
    
    public Course getCourse(String name) {
        CourseMeta m = CourseMeta.get();
        return Datastore.query(m)
                .filter(m.name.equal(name))
                .asSingle();
    }
    
    public List<Course> findCourses(String areaName, String keyword) throws Exception {
        
        if (areaName == null && keyword == null) 
            return null;
        
        CourseMeta m = CourseMeta.get();
        List<FilterCriterion> filters = new ArrayList<FilterCriterion>();
        if (areaName != null) {
            Area area = getArea(areaName);
            System.out.println(area.getName());
            filters.add(m.areaRef.equal(area.getKey()));
        }
        if (keyword != null) {
            System.out.println(keyword);
            filters.add(m.name.startsWith(keyword));
        }
        return Datastore.query(m)
                .filter(filters.toArray(new FilterCriterion[filters.size()]))
                .asList(); 
    }

    public Course createCourse(Course course) throws Exception {
        
        course.setKey(Datastore.allocateId(CourseMeta.get()));
        course.setCourseId(course.getKey().getId());
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
