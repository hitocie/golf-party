package com.xhills.golf_party.common.facebook;

import java.io.Serializable;
import java.util.List;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class Me implements Serializable {

    private static final long serialVersionUID = 1L;

    
    public User user;
    public List<User> friends;

    public Me(String accessToken) {

        FacebookClient client = new DefaultFacebookClient(accessToken);
        user = client.fetchObject("me", User.class);
        friends = client.fetchConnection("me/friends", User.class).getData();
        
    }
}
