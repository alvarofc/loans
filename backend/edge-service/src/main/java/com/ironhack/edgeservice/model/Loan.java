package com.ironhack.edgeservice.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Loan {
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal interest;
    private boolean repaid;

    public Loan() {
    }

    public Loan(BigDecimal quantity, BigDecimal interest, boolean repaid) {
        this.quantity = quantity;
        this.interest = interest;
        this.repaid = repaid;
    }
}
