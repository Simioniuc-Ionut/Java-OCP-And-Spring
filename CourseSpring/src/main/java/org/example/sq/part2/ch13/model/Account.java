package org.example.sq.part2.ch13.model;

import java.math.BigDecimal;

public class Account {

    private long id;
    private String name;
    private BigDecimal amount;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }
}
