package com.xhills.golf_party.common.facebook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.mortbay.log.Log;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.model.common.User;
import com.xhills.golf_party.service.common.UserService;

// Me impmentation for Facebook
public class MeForFB implements Me, Serializable {

    private static final long serialVersionUID = 1L;

    private transient FacebookClient client;
    private String accessToken;
    private User user;
    private List<User> friends;

    public String getAccessToken() {
        return accessToken;
    }

    public User getUser() {
        return user;
    }

    public List<User> getFriends() {
        return friends;
    }

    
    public MeForFB(String token) throws Exception {
        client = new DefaultFacebookClient(token);
        com.restfb.types.User fbUser = 
                client.fetchObject("me", com.restfb.types.User.class);
        
        UserService us = new UserService();
        String userid = fbUser.getId();
        user = us.getUser(userid);
        if (user == null) {
            user = new User();
            user.setUserid(userid);
            user.setUsername(fbUser.getName());
            user.setToken(token);
            us.createUser(user);
        }

        List<com.restfb.types.User> fbFriends = 
                client.fetchConnection("me/friends", com.restfb.types.User.class).getData();
        friends = new ArrayList<User>();
        for (com.restfb.types.User fbf : fbFriends) {
            User u = new User();
            u.setUserid(fbf.getId());
            u.setUsername(fbf.getName());
            friends.add(u);
        }

    }

    public void publishMessageToFeed(String msg) {
        
        FacebookType publishMessageResponse =
                client.publish(
                    "me/feed", 
                    FacebookType.class,
                    Parameter.with("message", msg));

        Log.info("Published message ID: " + publishMessageResponse.getId());
    }
}
