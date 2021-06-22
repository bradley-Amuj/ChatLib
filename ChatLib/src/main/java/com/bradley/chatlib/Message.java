package com.bradley.chatlib;

import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;

import java.util.Date;

public class Message implements IMessage {

    public String id;
    public String text;
    public User user;
    public Date createdAt;


    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Message() {

    }

    public Message(String id, User user, String text) {

        this.id = id;
        this.user = user;
        this.text = text;
        createdAt = new Date();

    }


    public Message(String id, User user, String text, Date createdAt) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.createdAt = createdAt;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public IUser getUser() {
        return this.user;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user.getId() +
                ", createdAt=" + createdAt +
                '}';
    }
}
