package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Doctor_Appoinment_payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_appoinment_payment);

        ActionBar DocActionBar2 = getSupportActionBar();
        DocActionBar2.setTitle("Doctor Booking Payment");
        DocActionBar2.setDisplayShowHomeEnabled(true);
        DocActionBar2.setDisplayHomeAsUpEnabled(true);

        int Drpay = getIntent().getIntExtra("pay",0);
        TextView textVD = findViewById(R.id.docpayment);
        textVD.setText(String.valueOf(Drpay));

    }
}