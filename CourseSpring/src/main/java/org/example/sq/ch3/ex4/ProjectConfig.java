package org.example.sq.ch3.ex4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example.sq.ch3.ex4")
public class ProjectConfig {
    @Bean
    Parrot parrot1(){
        Parrot p = new Parrot();
        p.setName("Wiki");
        return p;
    }

    @Bean
    Parrot parrot2(){
        Parrot p = new Parrot();
        p.setName("Kiki");
        return p;
    }
}
