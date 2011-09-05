package com.xhills.golf_party.controller.course;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.xhills.golf_party.common.facebook.Me;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        String service = asString("service");
        Me me = (Me) sessionScope("me");
        if (me != null) {
            if (service.equals("get_courses")) {
                // TODO:
            }
        }
        
        return null;
    }
}
