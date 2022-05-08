package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthCare_Welcome extends AppCompatActivity {

    Button addMeal,BMI,detail;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_welcome);

        ActionBar actionBar1 = getSupportActionBar();
        actionBar1.setTitle("Welcome Health Care");
        actionBar1.setDisplayShowHomeEnabled(true);
        actionBar1.setDisplayHomeAsUpEnabled(true);

        addMeal = findViewById(R.id.addMeal);
        BMI= findViewById(R.id.BMI);
        detail = findViewById(R.id.details);
        context = this;

        addMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,HealthCare_MealList_Add.class));
            }
        });

        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,HealthCare_BMI.class));
            }
        });

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,HealthCare_Details.class));
            }
        });



    }
    }

