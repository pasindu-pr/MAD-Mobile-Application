package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Booking_DayCare extends AppCompatActivity {
    Button button4;
    private EditText Bedogname, Bedogbreed,Bedogage, Bedogin,Bedogout,Bedogpackageno;
    private Button addbooking;
    //private DBHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_day_care);

        /*action bar*/
        ActionBar actionBar4 = getSupportActionBar();
        actionBar4.setTitle("DayCare Booking");
        actionBar4.setDisplayShowHomeEnabled(true);
        actionBar4.setDisplayHomeAsUpEnabled(true);

        /*pass varibles*/
        Bedogname = findViewById(R.id.Dog_Name);
        Bedogbreed = findViewById(R.id.Dog_Breed);
        Bedogage= findViewById(R.id.Dog_Age);
        Bedogin= findViewById(R.id.Dog_In);
        Bedogout= findViewById(R.id.Dog_Out);
        Bedogpackageno = findViewById(R.id.Dog_PackageNo);
        context = this;
        addbooking = findViewById(R.id.addBooking);



    }

}