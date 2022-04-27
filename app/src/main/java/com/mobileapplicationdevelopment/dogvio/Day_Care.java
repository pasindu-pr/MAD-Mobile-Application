package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Day_Care extends AppCompatActivity {

    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_care);

        ActionBar actionBar1 = getSupportActionBar();
        actionBar1.setTitle("Customer Page");
        actionBar1.setDisplayShowHomeEnabled(true);
        actionBar1.setDisplayHomeAsUpEnabled(true);

        button2 = findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), Old_Customer.class);
                startActivity(intent2);
            }
        });
    }
}