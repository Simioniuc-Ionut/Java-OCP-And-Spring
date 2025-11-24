package org.example.sq.ch5.services;

import org.example.sq.ch5.ProcessObj;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {
    final ApplicationContext context;

    public ProcessService(ApplicationContext context) {
        this.context = context;
    }

    public ProcessObj getAnProcessObj(){
        var procObj = context.getBean(ProcessObj.class);
        return procObj;
    }
}

