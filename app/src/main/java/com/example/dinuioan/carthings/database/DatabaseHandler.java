package com.example.dinuioan.carthings.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dinuioan.carthings.model.Car;
import com.example.dinuioan.carthings.model.CarThingEntity;

import java.nio.channels.SelectableChannel;
import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "carThingsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String ID = "id";

    private static final String CAR_TABLE = "car";
    private static final String CAR_TYPE = "car_type";

    private static final String CAR_THING_TABLE = "car_things";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String DATE = "date";
    private static final String ALARM = "alarm";
    private static final String CAR = "car";
    private static final String MILEAGE = "mileage";
    private static final String IS_SERVICE = "is_service";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CAR_TABLE = "create table " + CAR_TABLE +
                " ( "
                    + ID + " integer primary key autoincrement, "
                    + CAR_TYPE + " text " +
                " )";
        String CREATE_CAR_THINGS_TABLE = "create table " + CAR_THING_TABLE +
                " ( "
                    + ID + " integer primary key autoincrement, "
                    + NAME + " text, "
                    + DESCRIPTION + " text, "
                    + PRICE + " real, "
                    + DATE + " text, "
                    + ALARM + " integer, "
                    + CAR + " integer, "
                    + MILEAGE + " integer, "
                    + IS_SERVICE + " integer, "
                    + " FOREIGN KEY(car) REFERENCES car(id) " +
                " )";
        sqLiteDatabase.execSQL(CREATE_CAR_TABLE);
        sqLiteDatabase.execSQL(CREATE_CAR_THINGS_TABLE);
        sqLiteDatabase.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + CAR_TABLE);
        sqLiteDatabase.execSQL("drop table if exists " + CAR_THING_TABLE);
        onCreate(sqLiteDatabase);
    }

    // ADD
    public void addCar(Car car) {
        SQLiteDatabase database = getWritableDatabase();
        String ADD_CAR = "insert into " + CAR_TABLE +
                " values(null, '" + car.getType() + "')" ;
        database.execSQL(ADD_CAR);
        database.close();
    }

    public void addCarThing(CarThingEntity carThingEntity) {
        SQLiteDatabase database = getWritableDatabase();
        String ADD_CAR_THING = "insert into " + CAR_THING_TABLE +
                "values(null, '"
                + carThingEntity.getName() + "', '"
                + carThingEntity.getDescription() + "', '"
                + carThingEntity.getPrice() + "', '"
                + carThingEntity.getDate() + "', '"
                + carThingEntity.isAlarmSet() + "', '"
                + carThingEntity.getCarId() + "', '"
                + carThingEntity.getMileage() + "', '"
                + carThingEntity.isServiceType() +
                "')";
        database.execSQL(ADD_CAR_THING);
        database.close();
    }

    // FIND
    public Car findCarById(int id) {
        SQLiteDatabase database = getReadableDatabase();
        String SELECT_CAR_BY_ID = "select * from " + CAR_TABLE +
                " where " + ID + " = " + id;
        Cursor cursor = database.rawQuery(SELECT_CAR_BY_ID, null);
        Car car = new Car();

        if (cursor.moveToFirst()) {
            car.setId(cursor.getInt(0));
            car.setType(cursor.getString(1));
        }
        cursor.close();
        database.close();
        return car;
    }

    public CarThingEntity findCarThingEntityById(int id) {
        SQLiteDatabase database = getReadableDatabase();
        String SELECT_CAR_THING_BY_ID = "select * from " + CAR_THING_TABLE +
                " where " + ID + " = " + id;
        Cursor cursor = database.rawQuery(SELECT_CAR_THING_BY_ID, null);
        CarThingEntity carThingEntity = new CarThingEntity();

        if (cursor.moveToFirst()) {
            carThingEntity.setId(cursor.getInt(0));
            carThingEntity.setName(cursor.getString(1));
            carThingEntity.setDescription(cursor.getString(2));
            carThingEntity.setPrice(cursor.getFloat(3));
            carThingEntity.setDate(cursor.getString(4));
            carThingEntity.setAlarmSet(cursor.getInt(5));
            carThingEntity.setCarId(cursor.getInt(6));
            carThingEntity.setMileage(cursor.getInt(7));
            carThingEntity.setServiceType(cursor.getInt(8));
        }
        cursor.close();
        database.close();
        return carThingEntity;
    }

    // FIND ALL
    public List<Car> findAllCars() {
        SQLiteDatabase database = getReadableDatabase();
        String SELECT_ALL_CARS = "select * from " + CAR_TABLE;
        Cursor cursor = database.rawQuery(SELECT_ALL_CARS, null);
        List<Car> cars = new ArrayList<>();

        while (cursor.moveToNext()) {
            Car car = new Car();
            car.setId(cursor.getInt(0));
            car.setType(cursor.getString(1));
            cars.add(car);
        }
        cursor.close();
        database.close();
        return cars;
    }

    public List<CarThingEntity> findAllCarThings() {
        SQLiteDatabase database = getReadableDatabase();
        String SELECT_ALL_CAR_THINGS = "select * from " + CAR_THING_TABLE;
        Cursor cursor = database.rawQuery(SELECT_ALL_CAR_THINGS, null);
        List<CarThingEntity> carThingEntities = new ArrayList<>();

        while (cursor.moveToNext()) {
            CarThingEntity carThingEntity = new CarThingEntity();
            carThingEntity.setId(cursor.getInt(0));
            carThingEntity.setName(cursor.getString(1));
            carThingEntity.setDescription(cursor.getString(2));
            carThingEntity.setPrice(cursor.getFloat(3));
            carThingEntity.setDate(cursor.getString(4));
            carThingEntity.setAlarmSet(cursor.getInt(5));
            carThingEntity.setCarId(cursor.getInt(6));
            carThingEntity.setMileage(cursor.getInt(7));
            carThingEntity.setServiceType(cursor.getInt(8));
            carThingEntities.add(carThingEntity);
        }
        cursor.close();
        database.close();
        return carThingEntities;
    }
 }
