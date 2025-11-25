package org.example.sq.ch6;

import org.example.sq.ch6.aop.LoggingAspect;
import org.example.sq.ch6.aop.SecurityAspect;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"org.example.sq.ch6"})
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public LoggingAspect aspect(){
        return new LoggingAspect();
    }

    @Bean
    public SecurityAspect secure(){
        return new SecurityAspect();
    }
}
