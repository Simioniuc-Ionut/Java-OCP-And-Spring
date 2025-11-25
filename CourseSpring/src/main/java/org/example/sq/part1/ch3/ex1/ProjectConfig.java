package org.example.sq.part1.ch3.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Kiki");
        return p;
    }

    @Bean
    Person person(Parrot parrot){
        Person p = new Person();
        p.setName("Gigi");
        p.setParrot(parrot);
        return p;
    }
}
