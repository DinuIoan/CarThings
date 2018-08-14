package com.example.dinuioan.carthings.model;

import java.util.Date;

public class CarThingEntity {
    private int id;
    private String name;
    private String description;
    private float price;
    private String date;
    private int alarmSet;
    private int carId;
    private int mileage;
    private int serviceType;

    public CarThingEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int isAlarmSet() {
        return alarmSet;
    }

    public void setAlarmSet(int alarmSet) {
        this.alarmSet = alarmSet;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int isServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }
}
