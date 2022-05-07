package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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

        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.toast_layout));

        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        LayoutInflater layoutInflater1 = getLayoutInflater();
        View layout1 = layoutInflater1.inflate(R.layout.customtoastcalculator,(ViewGroup) findViewById(R.id.toast_layout));

        final Toast toast1 = new Toast(getApplicationContext());
        toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast1.setDuration(Toast.LENGTH_LONG);
        toast1.setView(layout1);


       bookingGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast.show();
                Intent intent4 = new Intent(getApplicationContext(),Booking_DayCare.class);
                startActivity(intent4);

            }
        });

       calculatorGo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               toast1.show();
               Intent intent5 = new Intent(getApplicationContext(),Calculator.class);
               startActivity(intent5);
           }
       });
    }
}