package org.example.sq.part1.ch5.services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProcessStereotypeEagerService {
    ProcessStereotypeEagerService(){
        System.out.println("Process Stereotype eager initialized!");
    }
}
