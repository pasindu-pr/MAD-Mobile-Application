package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Doctor_delete_popup_msg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_delete_popup_msg);

        ActionBar DocActionBar4 = getSupportActionBar();
        DocActionBar4.setTitle("Delete Appointment");
        DocActionBar4.setDisplayShowHomeEnabled(true);
        DocActionBar4.setDisplayHomeAsUpEnabled(true);
    }
}