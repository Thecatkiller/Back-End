package com.opso.cheapshop.resource;

import com.opso.cheapshop.domain.model.AuditModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResource {

    private Long id;
    private String firstname;
    private String lastname;
    private Long postalCode;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private double money;

}