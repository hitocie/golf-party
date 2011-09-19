package com.xhills.golf_party.controller.api.v1.auth.local;

import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.common.local.MeForLocal;
import com.xhills.golf_party.model.common.User;
import com.xhills.golf_party.service.common.UserService;

public class IndexController extends Controller {
    
    private Logger log = Logger.getLogger(getClass().getName());


    @Override
    public Navigation run() throws Exception {
        
        UserService us = new UserService();
        User user = us.getUser(asString("id"));
        if (user == null) {
            user = new User();
            user.setId(asString("id"));
            user.setName(asString("name"));
            user.setToken("");
            user = us.createUser(user);
        }
        
        Me me = new MeForLocal(user);
        sessionScope("me", me);
        log.info(me.getUser().getName() + " logged in");
        
        user.toJSONObject().write(response.getWriter());
        
        return null;
    }
}
