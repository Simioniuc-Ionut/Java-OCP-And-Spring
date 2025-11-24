package org.example.sq.ch2.ex5;

import org.example.sq.ch2.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class MainApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext();

        Parrot x = new Parrot();
        x.setName("Kiki added");

        Supplier<Parrot> sup = () -> x;

        context.registerBean("parrot1",Parrot.class,sup);
        context.refresh();

        Parrot p1 = context.getBean("parrot1", Parrot.class);
        System.out.println(p1.getName());
    }
}
