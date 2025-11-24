package org.example.sq.ch2.ex3;

import org.example.sq.ch2.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Project1.class);

//        Parrot p1 = context.getBean("parrot1", Parrot.class);
//        Parrot p2 = context.getBean("parrot2", Parrot.class);
//        System.out.println(p1.getName());
//        System.out.println(p2.getName());

        Parrot koko = context.getBean("Koko", Parrot.class);
        Parrot mimi = context.getBean("Mimi", Parrot.class);
        Parrot wiki = context.getBean("parrot3", Parrot.class);
        System.out.println(wiki.getName());
        System.out.println(koko.getName());
        System.out.println("Here are a relation between beans "+ mimi.getName());
    }
}
