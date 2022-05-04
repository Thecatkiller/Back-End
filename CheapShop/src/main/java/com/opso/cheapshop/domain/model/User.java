package com.opso.cheapshop.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private Long postalCode;

    @NotNull
    private String dateOfBirth;

    @NotNull
    private String address;

    @NotNull
    private String phoneNumber;
    
    @NotNull
    private Double money;

    public User() {    }

    public User(@NotNull Long id,@NotNull String firstname,@NotNull String lastname,@NotNull Long postalCode,
                @NotNull String dateOfBirth,@NotNull String address,@NotNull String phoneNumber, @NotNull Double money) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.money=money;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id){
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public User setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public User setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    
    public Double getMoney() {
        return money;
    }

    public User setMoney(Double money){
        this.money = money;
        return this;
    }
    
}