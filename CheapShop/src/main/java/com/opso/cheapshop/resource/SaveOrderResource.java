package com.opso.cheapshop.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveOrderResource {


    
    @NotNull
    @NotBlank
    @Size(max=75)
    private  String date;

    @NotNull
    @NotBlank
    @Size(max=300)
    private String delivery_address;

    @NotNull
    private Double order_amount;

    @NotNull
    @NotBlank
    @Size(max=300)
    private String delivery_date;



}
