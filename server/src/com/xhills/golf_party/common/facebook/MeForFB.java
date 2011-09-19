package com.xhills.golf_party.common.facebook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.model.common.User;

// Me impmentation for Facebook
public class MeForFB implements Me, Serializable {

    private static final long serialVersionUID = 1L;

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

    
    public MeForFB(String accessToken) {
        this.accessToken = accessToken;
        FacebookClient client = new DefaultFacebookClient(accessToken);
        com.restfb.types.User fbuser = client.fetchObject("me", com.restfb.types.User.class);
        user = new User();
        user.setId(fbuser.getId());
        user.setName(fbuser.getName());
        // TODO: insert User to datastore.
        List<com.restfb.types.User> fbfriends = client.fetchConnection("me/friends", com.restfb.types.User.class).getData();
        friends = new ArrayList<User>();
        for (com.restfb.types.User f : fbfriends) {
            User friend = new User();
            friend.setId(f.getId());
            friend.setName(f.getName());
            friends.add(friend);
        }
    }
}
