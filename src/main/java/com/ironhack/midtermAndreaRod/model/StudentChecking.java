package com.ironhack.midtermAndreaRod.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "accountId")
public class StudentChecking extends Account{

    public StudentChecking() {
    }

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
    }
}
