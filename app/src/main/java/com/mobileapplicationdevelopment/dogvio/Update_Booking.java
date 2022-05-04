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

        String dogname2 = getIntent().getStringExtra("Keydogname1");
        String dogbreed2 = getIntent().getStringExtra("Keydogbreed1");
        String dogage2 = getIntent().getStringExtra( "Keydogage1");
        String dogin2 = getIntent().getStringExtra("Keydogin1");
        String dogout2 = getIntent().getStringExtra("Keydogout1");
        String dogpack2 = getIntent().getStringExtra("Keydogpack1");

        EditText updatename = findViewById(R.id.UpdateDog_Name);
        EditText updatebreed = findViewById(R.id.UpdateDog_Breed);
        EditText updateage = findViewById(R.id.UpdateDog_Age);
        EditText updatein = findViewById(R.id.UpdateDog_In);
        EditText updateout = findViewById(R.id.UpdateDog_Out);
        EditText updatepackno = findViewById(R.id.UpdatePackgeNo);

        updatename.setText(dogname2);
        updatebreed.setText(dogbreed2);
        updateage.setText(dogage2);
        updatein.setText(dogin2);
        updateout.setText(dogout2);
        updatepackno.setText(dogpack2);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(getApplicationContext(), DisplayBooking.class);
                startActivity(intent5);


            }
        });
    }
}