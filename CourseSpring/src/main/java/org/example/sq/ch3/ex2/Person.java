package org.example.sq.ch3.ex2;

import org.example.sq.ch3.ex2.Parrot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    String name;

    @Autowired
    Parrot parrot;

    public void setName(String name) {
        this.name = name;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;
    }
}
