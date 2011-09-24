package com.xhills.golf_party.controller.api.v1.course;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.xhills.golf_party.common.Const;
import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.model.course.Course;
import com.xhills.golf_party.service.course.CourseService;

public class GetController extends Controller {

    @Override
    public Navigation run() throws Exception {

        response.setContentType(Const.charEncoding);

        String service = asString("service");
        if (service != null) {
            
            Me me = (Me) sessionScope("me");
            if (me != null) {
                if (service.equals("all_courses")) {
                    List<Course> courses = (new CourseService()).getAll();
                    JSONArray out = new JSONArray();
                    for (Course c : courses) {
                        out.put(c.toJSONObject());
                    }
                    out.write(response.getWriter());
                }
            }
        }
        
        return null;
    }
}
