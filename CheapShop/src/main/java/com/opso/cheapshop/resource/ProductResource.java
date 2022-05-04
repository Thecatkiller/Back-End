package com.opso.cheapshop.resource;

import com.opso.cheapshop.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResource extends AuditModel {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String urlImage;
    private int voteCounter;
    private int minimumToSold;
    /*
    private boolean alreadySold;
    */
    
    
}