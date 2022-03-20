package com.example.dogapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Daycare_Homepage extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daycare_homepage);

        ActionBar actionBar1 = getSupportActionBar();
        actionBar1.setTitle("Day Care");
        actionBar1.setDisplayShowHomeEnabled(true);
        actionBar1.setDisplayHomeAsUpEnabled(true);


        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), Old_Customer.class);
                startActivity(intent1);
            }
        });

    }
}