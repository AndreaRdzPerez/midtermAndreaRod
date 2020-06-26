package com.ironhack.midtermAndreaRod.model;

import com.ironhack.midtermAndreaRod.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Integer id;
    @Embedded
    protected Money balance;
    @ManyToOne()
    protected AccountHolder primaryOwner;
    @ManyToOne()
    protected AccountHolder secondaryOwner;
    protected BigDecimal penaltyFee;
    protected Status status;
    protected LocalDate lastAccessedDate;

    public Account() {
    }

    public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
    }

    //Getters & setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getLastAccessedDate() {
        return lastAccessedDate;
    }

    public void setLastAccessedDate(LocalDate lastAccessedDate) {
        this.lastAccessedDate = lastAccessedDate;
    }
}
