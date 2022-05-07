package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthCare_Welcome extends AppCompatActivity {

    Button button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_welcome);

        ActionBar actionBar1 = getSupportActionBar();
        actionBar1.setTitle("Welcome Health Care");
        actionBar1.setDisplayShowHomeEnabled(true);
        actionBar1.setDisplayHomeAsUpEnabled(true);


        button2 = findViewById(R.id.btn_BMI);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), HealthCare_BMI.class);
                startActivity(intent1);
            }
        });

        button3 = findViewById(R.id.btn_Details);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), HealthCare_Details.class);
                startActivity(intent1);
            }
        });

        button4 = findViewById(R.id.btn_Meal);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), HealthCare_MealNew.class);
                startActivity(intent1);
            }
        });
    }
    }

