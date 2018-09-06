package com.example.dinuioan.carthings.firstscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dinuioan.carthings.MainActivity;
import com.example.dinuioan.carthings.R;
import com.example.dinuioan.carthings.crud.AddCarActivity;
import com.facebook.stetho.Stetho;

public class FirstOpenActivity extends AppCompatActivity {
    private Button addCarButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_first_open);

        addCarButton = findViewById(R.id.button_add_car_first_open);
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            addCarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), AddCarActivity.class);
                    intent.putExtra("firstOpen", true);
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
