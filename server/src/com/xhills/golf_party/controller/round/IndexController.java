package com.xhills.golf_party.controller.round;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.xhills.golf_party.common.facebook.Me;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {

        String service = asString("service");
        Me me = (Me) sessionScope("me");
        if (me != null) {
            if (service.equals("create_round")) {
                // TODO:
            } else if (service.equals("update_round")) {
                // TODO:
            } else if (service.equals("delete_round")) {
                // TODO:
            } else if (service.equals("get_my_rounds")) {
                // TODO:
            }
        }

        return null;
    }
}
