package com.opso.cheapshop.resource;

import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveUserResource {

    @NotNull
    @Lob
    private String firstname;

    @NotNull
    @Lob
    private String lastname;

    @NotNull
    private Long postalCode;

    @NotNull
    private String dateOfBirth;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String address;

    @NotNull
    private String phoneNumber;

    @NotNull
    @Min(0)
    private double money;
}