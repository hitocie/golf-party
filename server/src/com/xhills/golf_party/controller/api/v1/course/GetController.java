package com.xhills.golf_party.controller.api.v1.course;

import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.xhills.golf_party.common.Const;
import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.model.course.Area;
import com.xhills.golf_party.model.course.Course;
import com.xhills.golf_party.service.course.CourseService;

public class GetController extends Controller {

    private Logger log = Logger.getLogger(getClass().getName());

    
    @Override
    public Navigation run() throws Exception {

        response.setContentType(Const.charEncoding);

        String service = asString("service");
        log.info("/course/get?service=" + service);
        if (service != null) {
            
            Me me = (Me) sessionScope("me");
            if (me != null) {

                if (service.equals("all_courses")) {
                    List<Course> courses = (new CourseService()).getAllCourses();
                    JSONArray out = new JSONArray();
                    for (Course c : courses) {
                        out.put(c.toJSONObject());
                    }
                    out.write(response.getWriter());
                    return null;
                    
                } else if (service.equals("all_areas")) {
                    List<Area> areas = (new CourseService()).getAllAreas();
                    JSONArray out = new JSONArray();
                    for (Area a : areas) {
                        out.put(a.getName());
                    }
                    out.write(response.getWriter());
                    return null;
                    
                } else if (service.equals("find_courses")) {
                    String area = (asString("area").equals("null") ? null : asString("area"));
                    String keyword = (asString("keyword").equals("null") ? null : asString("keyword"));
                    List<Course> courses = 
                            (new CourseService()).findCourses(area, keyword);
                    JSONArray out = new JSONArray();
                    for (Course c : courses) {
                        out.put(c.toJSONObject());
                    }
                    out.write(response.getWriter());
                    return null;
                    
                }
            }
        }
        
        return null;
    }
}
