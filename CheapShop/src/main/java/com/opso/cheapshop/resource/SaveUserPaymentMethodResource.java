package com.opso.cheapshop.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveUserPaymentMethodResource {

    @NotNull
    @NotBlank
    @Size(max = 16)
    private String cardNumber;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String ownerName;

    @NotNull
    @NotBlank
    @Size(max = 5)
    private String dueDate;

    @NotNull
    @NotBlank
    @Size(max = 3)
    private String cv;


}
