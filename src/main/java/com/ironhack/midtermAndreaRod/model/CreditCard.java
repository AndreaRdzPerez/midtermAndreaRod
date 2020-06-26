package com.ironhack.midtermAndreaRod.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(name = "accountId")
public class CreditCard extends Account {
    @DecimalMax(value = "1000.0", inclusive = true)
    @DecimalMin(value = "100.0", inclusive = true)
    protected BigDecimal creditLimit;
    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "0.2", inclusive = true)
    protected BigDecimal interestRate;

    public CreditCard() {
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, secondaryOwner);
        this.interestRate = BigDecimal.valueOf(0.2);
        this.creditLimit = BigDecimal.valueOf(100);
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, @DecimalMax(value = "1000.0", inclusive = true) @DecimalMin(value = "100.0", inclusive = true) BigDecimal creditLimit, @DecimalMin(value = "0.1", inclusive = true) @DecimalMax(value = "0.2", inclusive = true) BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
