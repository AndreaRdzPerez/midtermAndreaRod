package com.ironhack.midtermAndreaRod.model;

import com.ironhack.midtermAndreaRod.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(name = "accountId")
public class Savings extends Account{
    protected String secretKey;
    @DecimalMax(value = "0.5", inclusive = true)
    protected BigDecimal interestRate;
    @DecimalMax(value = "1000.0", inclusive = true)
    @DecimalMin(value = "100.0", inclusive = true)
    protected BigDecimal minimumBalance;

    //Empty constructor
    public Savings() {
    }

    //Constructor with default values
    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, secondaryOwner);
        this.interestRate = BigDecimal.valueOf(0.0025);
        this.minimumBalance = BigDecimal.valueOf(1000);
    }

    //Constructor without default values
    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, @DecimalMax(value = "0.5", inclusive = true) BigDecimal interestRate, @DecimalMax(value = "1000.0", inclusive = true) @DecimalMin(value = "100.0", inclusive = true) BigDecimal minimumBalance) {
        super(balance, primaryOwner, secondaryOwner);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
