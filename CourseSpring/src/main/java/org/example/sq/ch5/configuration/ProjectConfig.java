package org.example.sq.ch5.configuration;

import org.example.sq.ch5.ProcessObj;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.example.sq.ch5")
public class ProjectConfig {

    @Bean
    @Lazy
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ProcessObj processObj(){
        ProcessObj p = new ProcessObj();
        return p;
    }

}
