package org.example.sq.part1.SmartHomeController.configuration;

import org.example.sq.part1.SmartHomeController.aop.audit.LoggingAspect;
import org.example.sq.part1.SmartHomeController.repository.lightRepository.LightInMemoryRepository;
import org.example.sq.part1.SmartHomeController.repository.lightRepository.LightRepository;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.example.sq.part1.SmartHomeController")
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    @Lazy
    public LightRepository lightRepository(){
        return new LightInMemoryRepository();
    }

    @Bean
    public LoggingAspect logging(){
        return new LoggingAspect();
    }
}
