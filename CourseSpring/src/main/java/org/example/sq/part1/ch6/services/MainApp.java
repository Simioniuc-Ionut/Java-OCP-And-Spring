package org.example.sq.part1.ch6.services;

import org.example.sq.part1.ch6.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var logg = context.getBean(CommentService.class);
        logg.compute();
        System.out.println("In Main");
    }
}
