package com.example.dogapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calculator extends AppCompatActivity {
   Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        ActionBar actionBar9= getSupportActionBar();
        actionBar9.setTitle("Calculator");
        actionBar9.setDisplayShowHomeEnabled(true);
        actionBar9.setDisplayHomeAsUpEnabled(true);

        button1 = findViewById(R.id.button12);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(getApplicationContext(), Monthly_Memberships.class);
                startActivity(intent7);

            }
        });
    }
}