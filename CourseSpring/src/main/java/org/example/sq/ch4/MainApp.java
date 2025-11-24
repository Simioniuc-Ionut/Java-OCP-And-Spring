package org.example.sq.ch4;

import org.example.sq.ch4.DAO.Comment;
import org.example.sq.ch4.configuration.ProjectConfiguration;
import org.example.sq.ch4.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        Comment comment = new Comment("Hello Endava!", "Johny");
        var serviceComm = context.getBean(CommentService.class);
        serviceComm.publishComment(comment);
    }
}
