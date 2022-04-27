package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Old_Customer extends AppCompatActivity {

 Button button3;
 Button button3_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_customer);

        ActionBar actionBar3 = getSupportActionBar();
        actionBar3.setTitle("Day Care Service");
        actionBar3.setDisplayShowHomeEnabled(true);
        actionBar3.setDisplayHomeAsUpEnabled(true);


        button3 = findViewById(R.id.button);
        button3_1 = findViewById(R.id.button2);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), Monthly_Memberships.class);
                startActivity(intent3);
            }
        });

        button3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(), Monthly_Memberships.class);
                startActivity(intent4);
            }
        });

    }
}