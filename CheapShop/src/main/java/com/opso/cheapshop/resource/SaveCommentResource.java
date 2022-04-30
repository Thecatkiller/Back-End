package com.opso.cheapshop.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveCommentResource {
    @NotNull
    @Lob
    private String description;

}
