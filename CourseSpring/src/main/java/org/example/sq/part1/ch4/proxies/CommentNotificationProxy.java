package org.example.sq.part1.ch4.proxies;

import org.example.sq.part1.ch4.DAO.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
