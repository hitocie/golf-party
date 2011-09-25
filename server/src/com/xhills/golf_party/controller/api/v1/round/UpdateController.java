package com.xhills.golf_party.controller.api.v1.round;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.xhills.golf_party.common.Const;
import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.common.course.Half;
import com.xhills.golf_party.common.round.Weather;
import com.xhills.golf_party.common.round.Wind;
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
        
        response.setContentType(Const.charEncoding);

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
                    int weather = obj.getInt("weather");
                    if (weather == 0) 
                        round.setWeather(Weather.fine);
                    else if (weather == 1)
                        round.setWeather(Weather.cloudy);
                    else if (weather == 2)
                        round.setWeather(Weather.rainy);
                    else if (weather == 3)
                        round.setWeather(Weather.snow);
                    
                    int wind = obj.getInt("wind");
                    if (wind == 0)
                        round.setWind(Wind.strong);
                    else if (wind == 1)
                        round.setWind(Wind.weak);
                    else 
                        round.setWind(Wind.no);
                    
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
                    
                } else if (isPut()) {
                    // update
                    JSONObject obj = 
                            JSONUtil.inputStreamToJSONObject(request.getInputStream());
                    JSONArray scores = obj.getJSONArray("scores");
                    RoundService rs = new RoundService();
                    for (int i = 0; i < scores.length(); i++) {
                        JSONObject s = scores.getJSONObject(i);
                        long id = s.getLong("id");
                        int group = s.getInt("group");
                        int member = s.getInt("member");
                        int hole = s.getInt("hole");
                        int score = s.getInt("score");
                        int putter = s.getInt("putter");
                        rs.updateScore(id, group, member, hole, score, putter);
                    }
                    
                    response.getWriter().write("null");

                    return null;
                    
                } else if (isDelete()) {
                    // delete
                    JSONObject obj = 
                            JSONUtil.inputStreamToJSONObject(request.getInputStream());
                    RoundService rs = new RoundService();
                    rs.deleteRound(obj.getLong("id"));

                    response.getWriter().write("null");
                    
                    return null;
                }
            }
        }
        
        return null;

    }
}
