package com.opso.cheapshop.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveSupplierResource {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String description;

    @NotNull
    private Long number;

    @NotNull
    private String name;
}
