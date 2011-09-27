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
                    List<Round> rounds = (new RoundService()).getAllRounds();
                    JSONArray out = new JSONArray();
                    for (Round r : rounds) {
                        out.put(r.toJSONObject());
                    }
                    out.write(response.getWriter());
                    return null;
                    
                } else if (service.equals("my_rounds")) {
                    List<Round> rounds = (new RoundService()).getMyRounds(me.getUser());
                    JSONArray out = new JSONArray();
                    for (Round r : rounds) {
                        out.put(r.toJSONObject());
                    }
                    out.write(response.getWriter());                    
                    return null;

                } else if (service.equals("round")) {
                    long id = asLong("id");
                    Round round = (new RoundService()).getRound(id);
                    round.toJSONObject().write(response.getWriter());
                    return null;
    
                }
                
            }
        }
        
        return null;
    }
}
