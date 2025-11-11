package org.example.Chapter10;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public class Exercice{
        public static void ex1() {
            List<Integer> list  = List.of(10,20,30,40);
            IntStream a = list.stream().mapToInt((x) -> x);
            int[] b = a.toArray();
            // Without IntStream, we can't convert from List to a primitive array.
            // int[] c = list.toArray();
            List<Integer> listMutable = new ArrayList<>(List.of(1,2,3,4,5));
            listMutable.stream().map(x -> ++x).close();
            System.out.println("Mut list: " + listMutable);
        }
        public static void removeElementFromArray(){
            List s1 = new ArrayList( );
            s1.add("a");
            s1.add("b");
            s1.add("c");
            s1.add("a");
            if(s1.remove("a"))
            {     if(s1.remove("a")){
                s1.remove("b");
            }else{
                s1.remove("c");
            }
            } System.out.println(s1);
        }
        public static void subListReturnsAnView(){
            List list = new ArrayList();
            list.add("a");
            list.add("b");
            list.add("c");
            Function<List<String>,List<String>> f = (List<String> f1) -> f1.subList(1,2);
            List<String> view = f.apply(list);
            view.add("x");
            System.out.println(list);
        }
        public static void imutabilityList(){
            var numA = new Integer[] { 1, 2, 3};
            // Return a list view, reference to the original
            var list0 = Arrays.asList(numA);
            // Is a copy of the original
            var list1 = List.of(numA);
            var list2 = Collections.unmodifiableList(list1);
            var list3 = List.copyOf(Arrays.asList(numA));
            numA[1]=4;
            System.out.println(Arrays.stream(numA).toList());
            System.out.println("Copy of the original: \n"+ list1+ " " + list2 + " " + list3);
            System.out.println("The same object. A view!: " + list0);
        }
        public static void arrayDequeue(){
            var deq = new ArrayDeque<>();
            deq.addFirst(1);
            deq.addFirst(2);
            deq.addFirst(3);
            var que = new ArrayList<>();
            que.addFirst(1);
            que.addFirst(2);
            que.addFirst(3);
            System.out.println("Deq:" + deq);
            System.out.println("queu" + que);
        }
        public static void streamsEx(){
            var nums = IntStream.range(1, 5);
            double average = nums.mapToObj(i->i).collect(Collectors.averagingInt(i->i));
            System.out.println(average);

            List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17); //1
            Stream<Integer> primeStream = primes.stream(); //2

            System.out.println(            primeStream.count() + "---");
        }
        public static void arraysTrick(){
            int[][] ia = { {1, 2}, null };
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    System.out.println(ia[i][j]);
        }
    }

    public<T> Main(T a){
        System.out.println("Is a generic");
    }
    public Main(Integer a){
        System.out.println("Is a overloaded");
    }

    public static void main(String[] args) {
        Exercice.ex1();
        Main a  = new Main(123);
        Main b = new Main(123L);

        List<Integer> lon = List.of(1,2,3,4,5,6,7);
        lon.parallelStream().reduce(5,Integer::sum);
        String[] baba= {"a","C","b"};
        Collections.sort(Arrays.asList(baba),null);
        System.out.println(Arrays.stream(baba).toList());
        Comparator<Integer> comp = new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

      Exercice.removeElementFromArray();
      Exercice.subListReturnsAnView();
      Exercice.imutabilityList();
      Exercice.arrayDequeue();
      Exercice.streamsEx();
      loop : {
          while(true){
              break loop;
          }
      }

      int[] arr = new int[2];
      Integer[] objArr = new Integer[2];
        System.out.println("Array primitive print: " + arr + '\n' + "Array object print: " + objArr);
    }
}
class Person{
    String name;
    String dob;
    public Person(String name, String dob){
        this.name = name; this.dob = dob;
    }
}
class MySorter {
    public int compare(Person p1, Person p2){
        return p1.dob.compareTo(p2.dob);
    }
}

class SortTest {
    public static int diff(Person p1, Person p2){
        return p1.dob.compareTo(p2.dob);
    }
    public static int diff(Date d1, Date d2){
        return d1.compareTo(d2);
    }
    public static void main(String[] args) {
        ArrayList<Person> al = new ArrayList<>();
        al.add(new Person("Paul", "01012000"));
        al.add(new Person("Peter", "01011990"));
        al.add(new Person("Patrick", "01012002"));
        java.util.Collections.sort(al,(p1,p2) -> p1.dob.compareTo(p2.dob));
        java.util.Collections.sort(al, SortTest::diff);
        java.util.Collections.sort(al, new MySorter()::compare);

    }
}

