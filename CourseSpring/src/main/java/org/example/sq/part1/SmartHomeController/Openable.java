package org.example.sq.part1.SmartHomeController;

public interface Openable<T> {
    void turnOn(T... id);
    void turnOff(T... id);
}
