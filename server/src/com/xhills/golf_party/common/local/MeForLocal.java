package com.xhills.golf_party.common.local;

import java.io.Serializable;
import java.util.List;

import com.xhills.golf_party.common.Me;
import com.xhills.golf_party.model.common.User;

public class MeForLocal implements Me, Serializable {

    private static final long serialVersionUID = 1L;

    private User user;
    private List<User> friends;

    public String getAccessToken() {
        return null;
    }

    public User getUser() {
        return user;
    }

    public List<User> getFriends() {
        return friends;
    }

    
    public MeForLocal(User user) {
        this.user = user;
    }

    public void publishMessageToFeed(String msg) {
        // do nothing
    }
}
