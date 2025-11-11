package org.example.Chapter10;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface House{   public default String getAddress(){      return "101 Main Str";   } }
interface Bungalow extends House{   public default String getAddress(){      return "101 Smart Str";   } }
class MyHouse implements Bungalow, House{  }
enum ABA implements Serializable { AAA("ceva1"), BBB("ceva2");
    private String ceva;
    private static String prefix;
    public static enum BBB{ aaa }
    ABA(String ceva){
        this.ceva=ceva;
    }
    public String meth() {  return prefix+"aa";}
    public String toString(){
    return String.valueOf(ceva);
    }
}
enum Pets implements java.io.Serializable {
    DOG("D"), CAT("C"), FISH("F");
    String name;
    Pets(String s) { }
    public String getData(){ return name; }
}
enum Pets1 { DOG(1, "D")
    , CAT(2, "C") { public String getData(){ return type+name; } },
    FISH(3, "F");
    int type;
    String name;
    Pets1(int t, String s) { this.name = s; this.type = t;}
    public String getData(){ return name+type; }
}
public class TestClass  {
    public static void main(String[] args) {
        House ci = new MyHouse();  //1
        System.out.println(ci.getAddress()); //2   }
        String a = String.valueOf(ABA.AAA);
        System.out.println("Enum "+ a);
        Stream<Integer> stre = List.of(1,2,3).stream();

        Pets dog = Pets.valueOf("DOG");
        System.out.println("Enum toString is : " + dog);

        List<? super Integer> nums = new ArrayList<>(List.of(123,"aa",2.0));
        nums.add(30);
        System.out.println(nums);


    }

    public abstract class A<T extends Number>{
        public abstract  <E extends CharSequence & Serializable> List<? super E> doIt(List<E> nums);
        public abstract <E extends T> List<T> blabla(E o);
        public abstract <A,B,C>Map<A,B> multiGenerics(C param);
        short s = 10;
    }

}

interface A1 {
    int Exemple();
    void AAA();
    int A();
}
interface A2{
    void Implement();
}
record B3(int A, int Exemple) implements A2, A1 {
    public void Implement(){

    }
    public void AAA(){

    }
}