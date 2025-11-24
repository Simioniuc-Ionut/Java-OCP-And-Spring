package org.example.Exercices;

import java.io.*;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface B{
    public static void test(){
        System.out.println("Interface test");
    }
}
class D{
    public static void test2(){
        System.out.println("Test D");
    }
}
class A extends D{
    public static void test(){
        System.out.println("A test");
    }
    public static void test2(){
        System.out.println("Test A");
    }
}

class C extends A implements B{
    static void main() {
        String str = """
                0123\
                4567""";
        System.out.println(str.substring(4,7));

        String[] sa = { "charlie", "bob", "andy", "dave" };
        var ls = new ArrayList<String>(Arrays.asList(sa));
        ls.sort((var a, var b) -> a.compareTo(b));
        System.out.println(sa[0] + " " + ls.get(0));
        System.out.println(Stream.of("a","a","dada","dada","b","c").collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

//        Optional<Double> a =Optional.of(fun(2));
        Comparator<Integer> a = (a2,b) -> a2.compareTo(b);

    }
    static Double fun(int a){
        return null;
    }
}
public class ConcurrencyChapter {
    static class AA{
        int age;
    }

    class Ab { static int id = 2;}
    class Bc extends Ab{}


    static void main() throws Exception{
        AtomicInteger a = new AtomicInteger(0);

        System.out.println(a.incrementAndGet());
        System.out.println(a.addAndGet(1));

        var sList = new CopyOnWriteArrayList<>();

        LocalDateTime dt = LocalDateTime.parse("2022-01-02T17:13:50");
        String b = "a";
        System.out.println(b.concat("a"));
        ArrayList<Integer> a12 = new ArrayList<>();

        Character c = 2;
        NavigableSet<Integer> set = new TreeSet<>();
        boolean aa;
        boolean bb=false;
        boolean cc=false;
        boolean bool = (aa = true) || (bb = true) && (cc = true);
        System.out.print(aa + ", " + bb + ", " + cc);

        LocalDate d1 = LocalDate.parse("2022-02-05", DateTimeFormatter.ISO_DATE);
        LocalDateTime d2 = LocalDateTime.of(2025,2,1,10,10);
        System.out.println(d1);
        System.out.println(d2);
        Duration dur =  Duration.ofDays(1);
        System.out.println(dur);
        Period per = Period.ofMonths(0);
        System.out.println(per);
        String res = String.valueOf(1).transform(x -> x.concat("Ce faci ba"));
        System.out.println(res);
        ArrayList
        int[] h = new int[1];
        h[0] = 1;
        int[] ha = new int[2];
        ha = h.clone();
        ha[0] = 2;
        Arrays.stream(h).forEach(System.out::println);
        Arrays.stream(ha).forEach(System.out::println);
        class inner{
            public void mm(){
                System.out.println(aa);
            }
        }
        TreeMap
        var b1 = false; var b2  = false;
        if (b2 = b1 != b2){    System.out.println("true"); } else{    System.out.println("false"); }
        AA ana = new AA();
        Supplier<Integer> sup = () -> { ana.age = 1; return ana.age; };

        System.out.println(exception());
        StringBuilder aka = new StringBuilder();

        AtomicInteger ai = new AtomicInteger(5);
//        int x = ai + 1;
        String[] students = { "Amit", "Babu", "Chetan", "Dhiraj" };

    }
    static int exception() throws Exception{
        try{
            System.out.println("1");
        }finally {
            System.out.println("2");
        }

        return 10;
    }
    record A(Float a, int... b) implements Serializable {

    }
    record Student(int id, String... subjects){
        @Override
        public int id(){
            return 10;
        }
        @Override
        public boolean equals(Object obj){
            return false;
        }
    }
}
