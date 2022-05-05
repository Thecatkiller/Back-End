package com.opso.cheapshop.domain.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="orders")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Timestamp purchase_date;

    @NotNull
    private String delivery_address;

    @NotNull
    private int quantity;
    
    @NotNull
    private String delivery_date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
      
    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }
    public Order setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
    
    public Order setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
        return this;
    }
    
    public Order setUserId(User user) {
        this.user = user;
        return this;
    }
    
    public Order setProductId(Product product) {
        this.product = product;
        return this;
    }
    

}
