package com.vanyailnitsk.store.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table
public class Brand {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public Brand() {
    }

    public Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
