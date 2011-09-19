package com.xhills.golf_party.common;

import java.util.List;

import com.xhills.golf_party.model.common.User;

/* Me */
public interface Me {

    public String getAccessToken();
    public User getUser();
    public List<User> getFriends();
}
