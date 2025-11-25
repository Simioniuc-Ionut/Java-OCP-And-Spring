package org.example.sq.part1.ch4.proxies;

import org.example.sq.part1.ch4.DAO.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailComment implements CommentNotificationProxy{

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Comment has been sent!: " + comment);
    }
}
