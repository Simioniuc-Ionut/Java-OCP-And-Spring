package org.example.sq.part1.ch5.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class DbCommentRepository implements CommentRepository{

    DbCommentRepository(){
        System.out.println("Db comm has been initialized");
    }

    @Override
    public void connect() {
        System.out.println("Connect db!");
    }
}
