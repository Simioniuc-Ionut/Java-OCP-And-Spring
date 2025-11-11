package org.example.Chapter13;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedCollection;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void sequancedExamples(){
        SequencedCollection<Integer> orderdCollection  = new LinkedHashSet<>();
        orderdCollection.addFirst(1);
        orderdCollection.add(2);
        orderdCollection.addLast(10);
        orderdCollection.forEach(System.out::print);
        orderdCollection.removeLast();
        orderdCollection.forEach(System.out::print);
    }
    public static void ex2(){
        var cats = Stream.of("leopard", "lynx", "ocelot", "puma")
           .parallel();
         var bears = Stream.of("panda","grizzly","polar").parallel();
         var data = Stream.of(cats,bears).flatMap(s -> s)
            .collect(Collectors.groupingByConcurrent(
                       s -> !s.startsWith("p")));
         System.out.println(data.get(false).size()
                    + " " + data.get(true).size());
    }

    static void main() {
        ScheduledExecutorService a =Executors.newSingleThreadScheduledExecutor();
        Thread.ofPlatform().unstarted(()-> System.out.println("")).run();
        ExecutorService service = Executors.newFixedThreadPool(5,Thread.ofVirtual().factory());
        sequancedExamples();
        ex2();

        CyclicBarrier c = new CyclicBarrier(10,()-> System.out.println("Hi"));
        try { c.await(); } catch (Exception e) {}
        for (int i = 0; i < 10; i++) {
            final int animal = i;
        }

        List.of(8, 7, 5, 9, 10).parallelStream().sorted().forEachOrdered(System.out::println);
    }
}
