package com.ironhack.midtermAndreaRod.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(name = "accountId")
public class Checking extends Account {
    protected String secretKey;
    protected BigDecimal minimumBalance;
    protected BigDecimal monthlyMaintenanceFee;

    public Checking() {
    }

    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = BigDecimal.valueOf(250);
        this.monthlyMaintenanceFee = BigDecimal.valueOf(12);
    }

    //getters & setters

    public String getSecretKey() { return secretKey; }

    public void setSecretKey(String secretKey) { this.secretKey = secretKey; }

    public BigDecimal getMinimumBalance() { return minimumBalance; }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}
