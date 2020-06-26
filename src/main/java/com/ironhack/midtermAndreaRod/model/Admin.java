package com.ironhack.midtermAndreaRod.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Admin extends User{
    private String name;


    public Admin() {
    }

    public Admin(Long id, String username, String password, Set<Role> roles, String name) {
        super(id, username, password, roles);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
