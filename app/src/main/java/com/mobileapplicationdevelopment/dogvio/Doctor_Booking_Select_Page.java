package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctor_Booking_Select_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_booking_select_page);

        ActionBar DocActionBar3 = getSupportActionBar();
        DocActionBar3.setTitle("Doctor Details");
        DocActionBar3.setDisplayShowHomeEnabled(true);
        DocActionBar3.setDisplayHomeAsUpEnabled(true);


        Button Button_BookNow1 = findViewById(R.id.see_more_1);
        Button Button_BookNow2 = findViewById(R.id.see_more2);
        Button Button_BookNow3 = findViewById(R.id.see_more_3);

        Button_BookNow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Doctor_Booking_Select_Page.this,Doctor_Time_Picking_page.class);
                startActivity(intent);
            }
        });

        Button_BookNow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Doctor_Booking_Select_Page.this,Doctor_Time_Picking_page.class);
                startActivity(intent);
            }
        });

        Button_BookNow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Doctor_Booking_Select_Page.this,Doctor_Time_Picking_page.class);
                startActivity(intent);
            }
        });

    }
}