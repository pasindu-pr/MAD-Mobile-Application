package com.example.dogapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HealthCare_BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_bmi);

        ActionBar actionBar2 = getSupportActionBar();
        actionBar2.setTitle("BMI");
        actionBar2.setDisplayShowHomeEnabled(true);
        actionBar2.setDisplayHomeAsUpEnabled(true);
    }
}