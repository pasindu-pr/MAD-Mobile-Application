package com.example.dogapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Booking_DayCare extends AppCompatActivity {
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_day_care);

        ActionBar actionBar4 = getSupportActionBar();
        actionBar4.setTitle("DayCare Booking");
        actionBar4.setDisplayShowHomeEnabled(true);
        actionBar4.setDisplayHomeAsUpEnabled(true);

        button4 = findViewById(R.id.button6);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(), DisplayBooking.class);
                startActivity(intent4);
            }
        });
    }
}