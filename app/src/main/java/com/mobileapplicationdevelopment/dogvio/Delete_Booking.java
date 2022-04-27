package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Delete_Booking extends AppCompatActivity {
   Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_booking);


        ActionBar actionBar6 = getSupportActionBar();
        actionBar6.setTitle("Delete Booking");
        actionBar6.setDisplayShowHomeEnabled(true);
        actionBar6.setDisplayHomeAsUpEnabled(true);


        button7 = findViewById(R.id.button6);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(getApplicationContext(), DisplayBooking.class);
                startActivity(intent5);
            }
        });
    }
}