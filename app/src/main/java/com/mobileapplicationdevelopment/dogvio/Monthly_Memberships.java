package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Monthly_Memberships extends AppCompatActivity {


    Button bookingGo;
    Button calculatorGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_memberships);

        ActionBar actionBar1 = getSupportActionBar();
        actionBar1.setTitle("Packages");
        actionBar1.setDisplayShowHomeEnabled(true);
        actionBar1.setDisplayHomeAsUpEnabled(true);


        bookingGo = findViewById(R.id.GoBook);
        calculatorGo = findViewById(R.id.Gocalculator);


       bookingGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(),Booking_DayCare.class);
                startActivity(intent4);
            }
        });

       calculatorGo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent5 = new Intent(getApplicationContext(),Calculator.class);
               startActivity(intent5);
           }
       });
    }
}