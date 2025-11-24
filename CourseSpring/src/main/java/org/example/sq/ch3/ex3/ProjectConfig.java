package org.example.sq.ch3.ex3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.sq.ch3.ex3")
public class ProjectConfig {
    @Bean
    Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Kiki");
        return p;
    }

}
