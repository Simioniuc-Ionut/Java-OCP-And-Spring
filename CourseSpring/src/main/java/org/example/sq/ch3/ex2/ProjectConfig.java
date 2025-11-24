package org.example.sq.ch3.ex2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.sq.ch3.ex2")
public class ProjectConfig {
    @Bean
    Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Kiki");
        return p;
    }

}
