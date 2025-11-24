package org.example.sq.ch5.services;


import org.example.sq.ch5.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    final CommentRepository commentRepository;

    CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
        System.out.println("Comment Service has been initialized");
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }
}
