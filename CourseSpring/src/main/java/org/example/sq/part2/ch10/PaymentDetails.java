package org.example.sq.part2.ch10;

public class PaymentDetails {
    private double amount;
    private String name;
    public PaymentDetails(String name, double nr) {
        amount=nr;
        this.name=name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
