package org.example.sq.part1.ch5;

public class ProcessObj {
    public static int counter = 0;
    public ProcessObj(){
        System.out.println("Process Obj has been lazy initialized!");
    }

    public String toString(){
        return "Process Obj" + ++counter;
    }
}
