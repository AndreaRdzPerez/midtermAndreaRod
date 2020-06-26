package com.ironhack.midtermAndreaRod.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String city;
    private int postalCode;
    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="primaryAddress")
    List<AccountHolder> primaryAddressesList = new ArrayList<>();
    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="mailingAddress")
    List<AccountHolder> mailingAddressesList = new ArrayList<>();

    public Address() {
    }

    public Address(String street, String city, int zipCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<AccountHolder> getPrimaryAddressesList() {
        return primaryAddressesList;
    }

    public void setPrimaryAddressesList(List<AccountHolder> primaryAddressesList) {
        this.primaryAddressesList = primaryAddressesList;
    }

    public List<AccountHolder> getMailingAddressesList() {
        return mailingAddressesList;
    }

    public void setMailingAddressesList(List<AccountHolder> mailingAddressesList) {
        this.mailingAddressesList = mailingAddressesList;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
