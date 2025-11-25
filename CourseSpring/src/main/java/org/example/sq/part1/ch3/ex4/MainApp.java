package org.example.sq.part1.ch3.ex4;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person prs = context.getBean(Person.class);

        System.out.println("Person :" + prs.getName() + " the parrot is : " +  prs.getParrot().getName());

    }
}
