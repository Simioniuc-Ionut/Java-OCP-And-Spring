package org.example.sq.part1.ch6.services;

import org.example.sq.part1.ch6.ToLog;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CommentService {
    private Logger logger =
            Logger.getLogger(CommentService.class.getName());

    public CommentService(){
        System.out.println("CommentService has been initialized!");
    }

    @ToLog
    public String compute(){
        logger.info("Publishing comment:");
        return "SUCCESS";
    }
}
