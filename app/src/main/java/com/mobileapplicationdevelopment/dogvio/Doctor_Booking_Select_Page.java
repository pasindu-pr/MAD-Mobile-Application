package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctor_Booking_Select_Page extends AppCompatActivity {

    String DrName1, DrName2, DrName3;



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

        final Intent intent = new Intent(Doctor_Booking_Select_Page.this,Doctor_Time_Picking_page.class);
        String DrName1 = "DR Rayen";
        intent.putExtra("DrName", DrName1);

        final Intent intent1 = new Intent(Doctor_Booking_Select_Page.this,Doctor_Time_Picking_page.class);
        String DrName2 = "DR Chaan";
        intent1.putExtra("DrName", DrName2);

        final Intent intent2 = new Intent(Doctor_Booking_Select_Page.this,Doctor_Time_Picking_page.class);
        String DrName3 = "DR Saam";
        intent2.putExtra("DrName", DrName3);

        Button_BookNow1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Button_BookNow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent1);
            }
        });

        Button_BookNow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent2);
            }
        });

    }
}