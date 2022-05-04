package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Update_Booking extends AppCompatActivity {
   Button button6;
   EditText updatename,updatebreed,updateage,updatein,updateout,updatepack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_booking);
        button6 = findViewById(R.id.addBooking);

        //updatepack = findViewById(R.id.UpdateDog_pa)

        /*action bar*/
        ActionBar actionBar6 = getSupportActionBar();
        actionBar6.setTitle("Update Booking");
        actionBar6.setDisplayShowHomeEnabled(true);
        actionBar6.setDisplayHomeAsUpEnabled(true);

        /*pass data*/
        String Udogname = getIntent().getStringExtra("Keydogname");
        String Udogbreef = getIntent().getStringExtra("Keydogbreed");
        String Udogage = getIntent().getStringExtra("Keydogage");
        String Udogin = getIntent().getStringExtra("Keydogin");
        String Udogout = getIntent().getStringExtra("Keydogout");
        String Udogpack = getIntent().getStringExtra("Keydogpack");


        EditText daycaredogname = findViewById(R.id.UpdateDog_Name);
        EditText daycaredogbreed = findViewById(R.id.UpdateDog_Breed);
        EditText daycaredogage = findViewById(R.id.UpdateDog_Age);
        EditText daycaredogin = findViewById(R.id.UpdateDog_In);
        EditText daycaredogout = findViewById(R.id.UpdateDog_Out);
        EditText daycaredogpack = findViewById(R.id.UpdatePackgeNo);

        daycaredogname.setText(Udogname);
        daycaredogbreed.setText(Udogbreef);
        daycaredogage.setText(Udogage);
        daycaredogin.setText(Udogin);
        daycaredogout.setText(Udogout);
        daycaredogpack.setText(Udogpack);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(getApplicationContext(), DisplayBooking.class);
                startActivity(intent5);


            }
        });
    }
}