package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Doctor_Appoinment_payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_appoinment_payment);

        ActionBar DocActionBar2 = getSupportActionBar();
        DocActionBar2.setTitle("Doctor Booking Payment");
        DocActionBar2.setDisplayShowHomeEnabled(true);
        DocActionBar2.setDisplayHomeAsUpEnabled(true);


    }
}