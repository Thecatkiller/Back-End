package com.opso.cheapshop.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trackings" )
public class Tracking extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String date;

    @NotNull
    private String description;


    @NotNull
    private String place;


    public Tracking() {
    }

    public Tracking(@NotNull String date, @NotNull String description, @NotNull String place) {
        this.date = date;
        this.description = description;
        this.place = place;
    }

    public long getId() {
        return id;
    }

    public Tracking setId(long id) {
        this.id = id;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Tracking setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Tracking setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Tracking setPlace(String place) {
        this.place = place;
        return this;
    }
}