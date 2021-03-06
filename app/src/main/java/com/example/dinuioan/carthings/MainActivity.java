package com.example.dinuioan.carthings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dinuioan.carthings.model.Car;
import com.example.dinuioan.carthings.service.CarServiceImpl;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {
    private TextView carNameTextView;
    private Car selectedCar;
    private CarServiceImpl carService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        carService = new CarServiceImpl(getApplicationContext());
        selectedCar = carService.getMainCar();

        carNameTextView = findViewById(R.id.car_name_text_view);

        carNameTextView.setText(selectedCar.getType());
    }
}
