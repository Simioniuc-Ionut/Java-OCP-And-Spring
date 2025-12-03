package org.example.sq.part2.ch11.servicePayment;

public class Payment {
    private String id;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}