package com.example.dogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctor_Time_Picking_data_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_time_picking_data_page);

        Button Button1a = findViewById(R.id.doc_page4_btn1);
        Button Button2a = findViewById(R.id.doc_page4_btn2);
        Button Button3a = findViewById(R.id.doc_page4_btn3);

        Button1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Doctor_Time_Picking_data_page.this,Doctor_Booking_main.class);
                startActivity(intent);
            }
        });

        Button2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Doctor_Time_Picking_data_page.this,Doctor_Time_Picking_page.class);
                startActivity(intent);
            }
        });

        Button3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Doctor_Time_Picking_data_page.this,Doctor_Booking_Delete_page.class);
                startActivity(intent);
            }
        });

    }
}