package com.xhills.golf_party.controller.sample;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.xhills.golf_party.common.facebook.App;

/** start page http://localhost:8888/sample/ **/
public class IndexController extends Controller {
  
    @Override
    public Navigation run() throws Exception {

        return redirect(
            "https://graph.facebook.com/oauth/authorize?client_id=" + App.appId + 
            "&redirect_uri=" + App.siteUrl +
            "&scope=publish_stream,offline_access,manage_pages");
    }
}
