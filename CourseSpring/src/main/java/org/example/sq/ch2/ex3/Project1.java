package org.example.sq.ch2.ex3;

import org.example.sq.ch2.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Project1 {
    @Bean("Koko")
    Parrot parrot1(){
        Parrot p = new Parrot();
        p.setName("Koko Jambo");
        return p;
    }

    @Bean(name = "Mimi")
    Parrot parrot2(){
        Parrot p = new Parrot();
        p.setName("Mimi");
        System.out.println("Here we use another bean " + parrot1().getName());
        return p;
    }
    @Bean
    Parrot parrot3(){
        Parrot p = new Parrot();
        p.setName("Wiki");
        return p;
    }
}
