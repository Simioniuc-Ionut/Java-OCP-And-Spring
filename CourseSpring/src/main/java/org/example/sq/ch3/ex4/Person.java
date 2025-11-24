package org.example.sq.ch3.ex4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    String name;

    final Parrot parrot;

    public Person(Parrot parrot1){
        this.parrot = parrot1;
        this.name="Gigi";
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;
    }
}
