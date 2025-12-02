package org.example.sq.part2.ch9;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@ApplicationScope
public class CounterService {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.getAndIncrement();
    }

    public int getCounter(){
        return counter.get();
    }
}
