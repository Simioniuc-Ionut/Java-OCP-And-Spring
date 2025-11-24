package org.example.sq.ch3.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    String name;

    final Parrot parrot;

    @Autowired
    public Person(Parrot parrot){
        this.parrot = parrot;
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
