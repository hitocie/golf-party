package com.xhills.golf_party.controller.api.v1.course;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.xhills.golf_party.common.Me;

public class GetController extends Controller {

    @Override
    public Navigation run() throws Exception {
        String service = asString("service");
        if (service != null) {
            
            Me me = (Me) sessionScope("me");
            if (me != null) {
                if (service.equals("all_courses")) {
                    // TODO:
                }
            }
        }
        
        return null;
    }
}
