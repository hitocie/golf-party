package com.xhills.golf_party.controller.api.v1.round;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.common.course.Half;
import com.xhills.golf_party.common.utils.DateUtil;
import com.xhills.golf_party.common.utils.JSONUtil;
import com.xhills.golf_party.model.course.Course;
import com.xhills.golf_party.model.round.Round;
import com.xhills.golf_party.model.round.RoundGroup;
import com.xhills.golf_party.model.round.RoundMember;
import com.xhills.golf_party.service.common.UserService;
import com.xhills.golf_party.service.course.CourseService;
import com.xhills.golf_party.service.round.RoundService;

public class UpdateController extends Controller {

    private Logger log = Logger.getLogger(getClass().getName());

    
    @Override
    public Navigation run() throws Exception {
        
        if (!isGet()) {
            
            Me me = (Me) sessionScope("me");
            if (me != null) {
                if (isPost()) {
                    // create
                    JSONObject obj = 
                            JSONUtil.inputStreamToJSONObject(request.getInputStream());
                    CourseService cs = new CourseService();
                    Round round = new Round();
                    round.setHalfs(new ArrayList<Half>());
                    Course course = cs.getCourse(obj.getString("course"));
                    round.getCourseRef().setModel(course);
                    for (Half h : course.getHalfs()) {
                        String name = h.getName();
                        if (name.equals(obj.getString("first_half"))) 
                            round.getHalfs().add(0, h);
                        
                        if (name.equals(obj.getString("last_half"))) 
                            round.getHalfs().add(1, h);
                    }
                    // TODO: wind, weather
                    String date = obj.getString("date");
                    if (date != null)
                        round.setDate(DateUtil.toDate(date));
                    
                    JSONArray groups = obj.getJSONArray("groups");
                    List<RoundGroup> roundGroups = round.getRoundGroupRef().getModelList();
                    for (int i = 0; i < groups.length(); i++) {
                        JSONArray members = groups.getJSONArray(i);
                        RoundGroup rg = new RoundGroup();
                        List<RoundMember> roundMembers = rg.getRoundMemberRef().getModelList();
                        for (int j = 0; j < members.length(); j++) {
                            JSONObject member = members.getJSONObject(j);
                            RoundMember rm = new RoundMember();
                            rm.getUserRef().setModel(
                                (new UserService()).getUser(member.getString("id")));
                            rm.getRoundGroupRef().setModel(rg);
                            roundMembers.add(rm);
                        }
                        rg.getRoundRef().setModel(round);
                        roundGroups.add(rg);
                    }
                    
                    RoundService rs = new RoundService();
                    round = rs.createRound(round);
                    log.info("Created new round. " + round.getCourseRef().getModel().getName());
                
                    round.toJSONObject().write(response.getWriter());
                    
                    return null;
                }
            }
        }
        
        return null;

    }
}
