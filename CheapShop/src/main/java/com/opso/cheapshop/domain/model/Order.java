package com.opso.cheapshop.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private  String date;

    @NotNull
    private String delivery_address;

    @NotNull
    private Double order_amount;

    @NotNull
    private String delivery_date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }
//////////////////

    public String getDate() {
        return date;
    }

    public Order setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDeliveryAddress() {
        return delivery_address;
    }

    public Order setDeliveryAddress(String delivery_address) {
        this.delivery_address = delivery_address;
        return this;
    }

    public Double getOrderAmount() {
        return order_amount;
    }

    public Order setOrderAmount(Double order_amount) {
        this.order_amount = order_amount;
        return this;
    }

    public String getDeliveryDate() {
        return delivery_date;
    }

    public Order setDeliveryDate(String delivery_date) {
        this.delivery_date = delivery_date;
        return this;
    }


    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }


}
