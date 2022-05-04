package com.opso.cheapshop.resource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.cucumber.java.eo.Se;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveOrderResource {

    @NotNull
    @NotBlank
    @Size(max=300)
    private String delivery_address;

    @NotNull
    @Min(1)
    private int quantity;

    @NotNull
    @NotBlank
    @Size(max=300)
    private String delivery_date;

    @NotNull
    private Long productId;

}
