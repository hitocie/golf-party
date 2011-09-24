package com.xhills.golf_party.controller.api.v1.round;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.xhills.golf_party.common.Const;
import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.model.round.Round;
import com.xhills.golf_party.service.round.RoundService;

public class GetController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        response.setContentType(Const.charEncoding);
        
        String service = asString("service");
        if (service != null) {
            
            Me me = (Me) sessionScope("me");
            if (me != null) {
                if (service.equals("all_rounds")) {
                    List<Round> rounds = (new RoundService()).getAll();
                    JSONArray out = new JSONArray();
                    for (Round r : rounds) {
                        out.put(r.toJSONObject());
                    }
                    out.write(response.getWriter());
                }
            }
        }
        
        return null;
    }
}
