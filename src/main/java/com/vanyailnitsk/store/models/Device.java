package com.vanyailnitsk.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Device {
    @Id
    @GeneratedValue
    private Integer deviceId;
    private String name;
    private Integer price;
    @Transient
    private Double rating;
    private String image;

    @ManyToOne
    @JoinColumn(name="type_id")
    @JsonIgnore
    private Type type;

    @ManyToOne
    @JoinColumn(name="brand_id")
    @JsonIgnore
    private Brand brand;
    @ManyToMany(mappedBy = "items",fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Basket> basket;

    public Device() {
    }

    public Device(String name, Integer price, Double rating, String image) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.image = image;
    }

    public Integer getDeviceId() {
        return deviceId;
    }


    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    public void setDeviceId(Integer deviceID) {
        this.deviceId = deviceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
