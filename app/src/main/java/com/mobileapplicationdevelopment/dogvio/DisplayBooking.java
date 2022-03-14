package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisplayBooking extends AppCompatActivity {

     Button button7;
     Button button10;
     Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_booking);

        ActionBar actionBar5 = getSupportActionBar();
        actionBar5.setTitle("Display Booking");
        actionBar5.setDisplayShowHomeEnabled(true);
        actionBar5.setDisplayHomeAsUpEnabled(true);

        button7 = findViewById(R.id.button7);
        button9 = findViewById(R.id.button9);
        button10  = findViewById(R.id.button8);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(getApplicationContext(), Update_Booking.class);
                startActivity(intent7);

            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), Delete_Booking.class);
                startActivity(intent1);
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(getApplicationContext(), Add_Bill.class);
                startActivity(intent9);

            }
        });

    }
}