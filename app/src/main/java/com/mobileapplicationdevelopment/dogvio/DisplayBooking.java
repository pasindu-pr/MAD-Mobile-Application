package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayBooking extends AppCompatActivity {

    Button Update_button;
    private TextView getdogname, getdogbreed,getdogage, getdogin,getdogout,getdogpackageno;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_booking);

        /*action bar*/
        ActionBar actionBar5 = getSupportActionBar();
        actionBar5.setTitle("Display Booking");
        actionBar5.setDisplayShowHomeEnabled(true);
        actionBar5.setDisplayHomeAsUpEnabled(true);

        Update_button = findViewById(R.id.UpdateButton);


        Update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentUpdate = new Intent(getApplicationContext(), Update_Booking.class);
                startActivity(intentUpdate);


            }
        });
    }}