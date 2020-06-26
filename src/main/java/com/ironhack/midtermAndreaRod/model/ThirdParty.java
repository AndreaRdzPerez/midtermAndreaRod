package com.ironhack.midtermAndreaRod.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class ThirdParty extends User{
    private String hashedKey;

    public ThirdParty() {
    }

    public ThirdParty(Long id, String username, String password, Set<Role> roles, String hashedKey) {
        super(id, username, password, roles);
        this.hashedKey = hashedKey;
    }

    public String getKey() {
        return hashedKey;
    }

    public void setKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }
}

