package com.xhills.golf_party.controller.me;

import java.io.Writer;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.restfb.types.User;
import com.xhills.golf_party.common.facebook.Me;

/**
   /me/
 */
public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        String service = asString("service"); //asInt

        Writer writer = this.response.getWriter();
        Me me = (Me) sessionScope("me");
        if (me != null) {

            if (service.equals("get_me")) {

                // service: get_me
                User user = me.user;
                JSONObject obj = new JSONObject();
                obj.put("id", user.getId());
                obj.put("name", user.getName());
                obj.write(writer);
                
            } else if (service.equals("get_my_friends")) {
            
                // service: get_my_friends
                List<User> friends = me.friends;
                JSONArray friendList = new JSONArray();
                for (int i = 0; i < friends.size(); i++) {
                    User friend = friends.get(i);
                    JSONObject f = new JSONObject();
                    f.put("id", friend.getId());
                    f.put("name", friend.getName());
                    friendList.put(f);
                }
                JSONObject obj = new JSONObject();
                obj.put("friends", friendList);
                obj.write(writer);
            }
        }
        
        return null;
    }
}
