package com.xhills.golf_party.controller.api.v1.course;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.org.json.JSONObject;
import com.xhills.golf_party.common.Const;
import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.common.course.Half;
import com.xhills.golf_party.common.course.Hole;
import com.xhills.golf_party.common.utils.JSONUtil;
import com.xhills.golf_party.model.course.Course;
import com.xhills.golf_party.service.course.CourseService;

public class UpdateController extends Controller {

    private Logger log = Logger.getLogger(getClass().getName());
    
    
    @Override
    public Navigation run() throws Exception {
        
        response.setContentType(Const.charEncoding);
        
        if (!isGet()) {
            
            Me me = (Me) sessionScope("me");
            if (me != null) {
                if (isPost()) {
                    // create
                    JSONObject obj = 
                            JSONUtil.inputStreamToJSONObject(request.getInputStream());
                    log.info("Create new course. " + obj.getString("name") + " " + obj.getString("address"));
                    Course course = new Course();
                    CourseService cs = new CourseService();

                    course.setName(obj.getString("name"));
                    course.getAreaRef().setModel(cs.getArea(obj.getString("area")));
                    course.setAddress(obj.getString("address"));
                    course.setHalfs(new ArrayList<Half>());
                    for (int i = 0; i < obj.getJSONArray("halfs").length(); i++) {
                        JSONObject halfObj = obj.getJSONArray("halfs").getJSONObject(i);
                        Half half = new Half();
                        half.setHoles(new ArrayList<Hole>());
                        half.setName(halfObj.getString("name"));
                        for (int j = 0; j < halfObj.getJSONArray("holes").length(); j++) {
                            JSONObject holeObj = halfObj.getJSONArray("holes").getJSONObject(j);
                            Hole hole = new Hole();
                            hole.setNo(holeObj.getInt("no"));
                            hole.setPar(holeObj.getInt("par"));
                            hole.setBackYard(holeObj.getInt("back"));
                            hole.setWhiteYard(holeObj.getInt("white"));
                            hole.setRedYard(holeObj.getInt("red"));
                            hole.setHandicap(holeObj.getInt("handicap"));
                            half.getHoles().add(hole);
                        }
                        course.getHalfs().add(half);
                    }
                    
                    course = cs.createCourse(course);
                    course.toJSONObject().write(response.getWriter());
                    
                    return null;
                    
                } else if (isDelete()) {
                    // delete
                    JSONObject obj = 
                            JSONUtil.inputStreamToJSONObject(request.getInputStream());
                    long id = obj.getLong("id");
                    log.info("Delete course. " + id);
                    CourseService cs = new CourseService();
                    cs.deleteCourse(id);
                    
                    response.getWriter().write("null");
                    return null;
                }
            }
        }
        return null;
    }
}
