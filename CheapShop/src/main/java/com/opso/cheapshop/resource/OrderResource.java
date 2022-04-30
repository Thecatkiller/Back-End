package com.opso.cheapshop.resource;

import com.opso.cheapshop.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResource extends AuditModel {

    private Long id;
    private String date;
    private String delivery_address;
    private String delivery_date;
    private Double order_amount;




}