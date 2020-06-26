package com.ironhack.midtermAndreaRod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "userId")
public class AccountHolder extends User{
    private String name;
    private LocalDate dateOfBirth;
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private Address primaryAddress;
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private Address mailingAddress;
    @JsonIgnore
    @OneToMany(mappedBy="primaryOwner", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private List<Checking> primaryOwner = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy="secondaryOwner", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private List<Checking> secondaryOwner = new ArrayList<>();

    public AccountHolder() {
    }

    public AccountHolder(Long id, String username, String password, Set<Role> roles, String name, LocalDate dateOfBirth, Address primaryAddress, Address mailingAddress) {
        super(id, username, password, roles);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public List<Checking> getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(List<Checking> primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public List<Checking> getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(List<Checking> secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
