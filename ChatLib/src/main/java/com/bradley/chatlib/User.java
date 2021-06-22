package com.bradley.chatlib;

import com.stfalcon.chatkit.commons.models.IUser;

public class User implements IUser {

    public String id;
    public String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAvatar() {
        return null;
    }
}
