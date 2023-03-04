package com.vanyailnitsk.store.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table
public class Type {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public Type() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
