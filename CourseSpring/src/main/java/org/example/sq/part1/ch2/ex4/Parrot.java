package org.example.sq.part1.ch2.ex4;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
    String name;

    @PostConstruct
    public void init(){
        this.name = "Kiki from post construct.";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
