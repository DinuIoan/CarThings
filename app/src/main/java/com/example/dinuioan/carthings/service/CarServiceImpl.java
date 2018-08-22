package com.example.dinuioan.carthings.service;

import android.content.Context;

import com.example.dinuioan.carthings.database.DatabaseHandler;
import com.example.dinuioan.carthings.model.Car;

public class CarServiceImpl implements CarService {
    private DatabaseHandler databaseHandler;

    public CarServiceImpl(Context context) {
        this.databaseHandler = new DatabaseHandler(context);
    }

    @Override
    public void addCar(Car car) {
        databaseHandler.addCar(car);
    }
}
