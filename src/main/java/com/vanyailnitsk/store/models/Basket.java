package com.vanyailnitsk.store.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Basket {
    @Id
    @GeneratedValue
    private Integer basketId;
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Override
    public String toString() {
        return "Basket{" +
                "basketId=" + basketId +
                ", items=" + items +
                '}';
    }
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "basket_device",
            joinColumns = { @JoinColumn(name = "basket_id") },
            inverseJoinColumns = { @JoinColumn(name = "device_id"),}
    )
    //@JoinColumn(name = "item_id")
    private List<Device> items = new ArrayList<>();

    public Basket() {
        this.items = new ArrayList<>();
    }

    public Basket(Integer basketId, List<Device> items) {
        this.basketId = basketId;
        this.items = items;
    }

    public void addItem(Device device) {
        items.add(device);
    }

    public Integer getBasketId() {
        return basketId;
    }

    public void setBasketId(Integer basketId) {
        this.basketId = basketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Device> getItems() {
        return items;
    }

    public void setItems(List<Device> items) {
        this.items = items;
    }
}
