package org.example.sq.ch2.ex2;

import org.example.sq.ch2.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Project1 {

    @Bean
    Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Red Parrot");
        return p;
    }

    @Bean
    Integer num(){
        return  10;
    }

    @Bean
    String hello(){
        return "Hello";
    }


}
