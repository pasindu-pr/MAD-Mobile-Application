package com.example.dogapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Monthly_Memberships extends AppCompatActivity {

    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_memberships);

        ActionBar actionBar1 = getSupportActionBar();
        actionBar1.setTitle("Monthly Membership");
        actionBar1.setDisplayShowHomeEnabled(true);
        actionBar1.setDisplayHomeAsUpEnabled(true);


        button3 = findViewById(R.id.button5);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), Booking_DayCare.class);
                startActivity(intent3);
            }
        });
    }
}