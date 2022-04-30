package com.opso.cheapshop.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveProductResource {

    @NotNull
    @NotBlank
    @Size(max=75)
    private String name;

    @NotNull
    private Double price;

    @NotNull
    @NotBlank
    @Size(max=300)
    private String description;

 
}
