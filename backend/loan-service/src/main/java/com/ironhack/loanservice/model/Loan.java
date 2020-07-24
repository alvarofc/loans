package com.ironhack.loanservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal interest;
    private boolean repaid;
    @DateTimeFormat
    private Date createdAt;
    @DateTimeFormat
    private Date matureDate;

    public Loan() {
    }

    public Loan(BigDecimal quantity, BigDecimal interest, boolean repaid, Date matureDate) {
        this.quantity = quantity;
        this.interest = interest;
        this.repaid = repaid;
        this.createdAt = new Date();
        this.matureDate = matureDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public boolean isRepaid() {
        return repaid;
    }

    public void setRepaid(boolean repaid) {
        this.repaid = repaid;
    }

    public Date getMatureDate() {
        return matureDate;
    }

    public void setMatureDate(Date matureDate) {
        this.matureDate = matureDate;
    }
}
