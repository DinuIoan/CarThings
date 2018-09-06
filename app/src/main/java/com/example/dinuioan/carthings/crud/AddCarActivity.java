package com.example.dinuioan.carthings.crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.dinuioan.carthings.MainActivity;
import com.example.dinuioan.carthings.R;
import com.example.dinuioan.carthings.model.Car;
import com.example.dinuioan.carthings.service.CarService;
import com.example.dinuioan.carthings.service.CarServiceImpl;

public class AddCarActivity extends AppCompatActivity {
    private Button addCarButton;
    private EditText editTextCarDescription;
    private CheckBox isMainCarCheckBox;
    private boolean isFirstOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        Intent intent = getIntent();
        isFirstOpen = intent.getBooleanExtra("firstOpen", false);

        addCarButton = findViewById(R.id.add_car_database_button);
        editTextCarDescription = findViewById(R.id.add_car_description_edit_text);
        isMainCarCheckBox = findViewById(R.id.is_main_car_checkbox);

        if (isFirstOpen) {
            isMainCarCheckBox.setChecked(true);
            isMainCarCheckBox.setEnabled(false);
        }

        addCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Car car = new Car();
                car.setType(editTextCarDescription.getText().toString());
                if (isMainCarCheckBox.isChecked()) {
                    car.setMainCar(1);
                } else {
                    car.setMainCar(0);
                }

                CarService carService = new CarServiceImpl(getApplicationContext());
                carService.addCar(car);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("carType", car.getType());
                getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                        .putBoolean("isFirstRun", false).apply();
                startActivity(intent);
                finish();
            }
        });
    }
}
