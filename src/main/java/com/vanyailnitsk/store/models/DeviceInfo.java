package com.vanyailnitsk.store.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table
public class DeviceInfo {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer deviceId;
    private String title;
    private String description;

    public DeviceInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceID(Integer deviceID) {
        this.deviceId = deviceID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
