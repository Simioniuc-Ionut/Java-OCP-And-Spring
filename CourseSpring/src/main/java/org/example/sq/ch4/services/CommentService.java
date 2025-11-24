package org.example.sq.ch4.services;

import org.example.sq.ch4.DAO.Comment;
import org.example.sq.ch4.proxies.CommentNotificationProxy;
import org.example.sq.ch4.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    final CommentRepository commentRepo;
    final CommentNotificationProxy commentProxy;

    CommentService(CommentRepository commentRepo, CommentNotificationProxy commentProxy){
        this.commentRepo=commentRepo;
        this.commentProxy=commentProxy;
    }

    public void publishComment(Comment comment){
        commentRepo.storeComment(comment);
        commentProxy.sendComment(comment);
        System.out.println("Comment has benn published!.");
    }
}
