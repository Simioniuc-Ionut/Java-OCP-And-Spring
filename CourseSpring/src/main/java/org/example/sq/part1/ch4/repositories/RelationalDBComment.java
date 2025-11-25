package org.example.sq.part1.ch4.repositories;

import org.example.sq.part1.ch4.DAO.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class RelationalDBComment implements CommentRepository{

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Comment has been stored! " + comment);
    }
}
