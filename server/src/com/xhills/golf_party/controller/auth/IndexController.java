package com.xhills.golf_party.controller.auth;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.xhills.golf_party.common.facebook.App;

/* /auth/ */
public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        String validationCode = asString("code");

        System.out.println("validation code=" + validationCode);

        String uri = 
                "https://graph.facebook.com/oauth/access_token?client_id=" + App.appId + 
                "&redirect_uri=" + App.siteUrl +
                "&client_secret=" + App.appSecret + 
                "&code=" + validationCode;
        return redirect(uri);

    }
}
