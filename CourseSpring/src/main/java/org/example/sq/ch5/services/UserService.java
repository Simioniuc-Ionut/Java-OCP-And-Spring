package org.example.sq.ch5.services;

import org.example.sq.ch5.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final CommentRepository commentRepository;
    UserService(CommentRepository commentService){
        this.commentRepository=commentService;
        System.out.println("User has been initialized!");
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }
}
