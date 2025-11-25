package org.example.sq.part1.ch3.ex1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        Person prs = context.getBean(Person.class);

        System.out.println("Parrot :" + p.getName());
        System.out.println("Person :" + prs.getName() + " the parrot is : " +  prs.getParrot().getName());

        System.out.println("Are the same parrot ?: " + (p == prs.getParrot()));
    }
}
