package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobileapplicationdevelopment.dogvio.daycareDatabase.DBDayCareHandler;
import com.mobileapplicationdevelopment.dogvio.daycareDatabase.DayCareModule;

public class Booking_DayCare extends AppCompatActivity {
    Button button4;
    private EditText Bedogname, Bedogbreed,Bedogage, Bedogin,Bedogout,Bedogpackageno;
    private Button addbooking;
    //private DBHandler dbHandler;
    private DBDayCareHandler dbDayCareHandler;
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
        addbooking = findViewById(R.id.addBooking);//addbutton

        dbDayCareHandler = new DBDayCareHandler(context);

        /*set button onclick function */
        addbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String adddogname = Bedogname.getText().toString();
                String adddogbreed = Bedogbreed.getText().toString();
                String adddogage = Bedogage.getText().toString();
                String adddogin = Bedogin.getText().toString();
                String adddogout = Bedogout.getText().toString();
                String addpackage = Bedogpackageno.getText().toString();
                long started = System.currentTimeMillis();

                DayCareModule simpledaycare = new DayCareModule(adddogname, adddogbreed, adddogage, adddogin, adddogout, addpackage,
                                                               started,0);

                int state = dbDayCareHandler.addBooking(simpledaycare);

                if(state > 0){
                    Toast.makeText(Booking_DayCare.this , "Data inserted sucessfully" , Toast.LENGTH_LONG).show();
                }

                startActivity(new Intent(context,ListDayCareAll.class));

            }
        });

    }




}