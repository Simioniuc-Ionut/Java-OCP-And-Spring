package org.example.sq.ch4.proxies;

import org.example.sq.ch4.DAO.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
