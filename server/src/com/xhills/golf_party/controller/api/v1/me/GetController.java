package com.xhills.golf_party.controller.api.v1.me;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.model.common.User;

public class GetController extends Controller {
    
    @Override
    public Navigation run() throws Exception {

        String service = asString("service");
        if (service != null) {

            Me me = (Me) sessionScope("me");
            if (me != null) {

                if (service.equals("me")) {

                    User user = me.getUser();
                    user.toJSONObject().write(response.getWriter());

                    return null;

                } else if (service.equals("my_friends")) {

                    JSONArray friends = new JSONArray();
                    for (User friend : me.getFriends()) {
                        friends.put(friend.toJSONObject());
                    }
                    friends.write(response.getWriter());
                    
                    return null;
                }
            }
        }        
        return null;
    }

}
