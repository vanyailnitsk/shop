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
    private Integer typeId;
    private Integer brandId;
    @ManyToMany(mappedBy = "items",fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Basket> basket;

    public Device() {
    }

    public Device(String name, Integer price, Double rating, String image, Integer typeId, Integer brandId) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.image = image;
        this.typeId = typeId;
        this.brandId = brandId;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
