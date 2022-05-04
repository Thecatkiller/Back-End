package com.opso.cheapshop.resource;

import com.opso.cheapshop.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class OrderResource {

    private Long id;
    private Timestamp purchase_date;
    private String delivery_address;
    private String delivery_date;
    private int quantity;

}