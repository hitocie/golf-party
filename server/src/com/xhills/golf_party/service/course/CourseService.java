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
    
    // with id
    public Course getCourse(long id) {
        CourseMeta m = CourseMeta.get();
        return Datastore.query(m)
                .filter(m.courseId.equal(id))
                .asSingle();
    }
    
    // with name
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
    
    
    public void deleteCourse(long id) throws Exception {
        
        Course course = getCourse(id);
        
        Transaction tx = Datastore.beginTransaction();
        try {
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
}
