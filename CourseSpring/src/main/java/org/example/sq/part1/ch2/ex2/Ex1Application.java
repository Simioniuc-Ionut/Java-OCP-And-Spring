package org.example.sq.part1.ch2.ex2;

import org.example.sq.part1.ch2.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex1Application {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Project1.class);
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Integer.class));
    }

}
