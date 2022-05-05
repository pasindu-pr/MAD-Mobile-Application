package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update_Booking extends AppCompatActivity {
   Button updatebutton;
   EditText updatename,updatebreed,updateage,updatein,updateout,updatepack;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_booking);
        updatebutton = findViewById(R.id.updatebooking);

        //updatepack = findViewById(R.id.UpdateDog_pa)

        /*action bar*/
        ActionBar actionBar6 = getSupportActionBar();
        actionBar6.setTitle("Update Booking");
        actionBar6.setDisplayShowHomeEnabled(true);
        actionBar6.setDisplayHomeAsUpEnabled(true);

    }
    }
