package com.ironhack.midtermAndreaRod.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "accountId")
public class StudentChecking extends Account{
    protected String secretKey;

    public StudentChecking() {
    }

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
