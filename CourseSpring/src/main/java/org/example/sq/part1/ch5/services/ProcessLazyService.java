package org.example.sq.part1.ch5.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class ProcessLazyService {
    ProcessLazyService(){
        System.out.println("Process lazy has been initialized!");
    }
}
