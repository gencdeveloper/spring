package com.cydeo.proxy;

import com.cydeo.model.Comment;

//we creeate interface, maybe in future scenari can change or add new feature so it is good for interface
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
