package org.example.sq.part2.ch14.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {

    @Id
    private long id;

    private String name;
    private BigDecimal amount;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
