package com.xhills.golf_party.controller.api.v1.auth.facebook;

import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.xhills.golf_party.common.Const;
import com.xhills.golf_party.common.Me;

public class CheckController extends Controller {

    private Logger log = Logger.getLogger(getClass().getName());


    @Override
    public Navigation run() throws Exception {
        
        response.setContentType(Const.charEncoding);

        String service = asString("service");
        if (service != null) {
            log.info("service=" + service);
            if (service.equals("login")) {
                Me me = (Me) sessionScope("me");
                response.getWriter().write((me != null) + "");
                return null;
            }
        }
        
        return null;
    }
}
