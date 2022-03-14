package com.example.dogapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Add_Bill extends AppCompatActivity {
   Button button9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        ActionBar actionBar8 = getSupportActionBar();
        actionBar8.setTitle("Payment Bill");
        actionBar8.setDisplayShowHomeEnabled(true);
        actionBar8.setDisplayHomeAsUpEnabled(true);

        button9 = findViewById(R.id.button10);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(getApplicationContext(), ContactUs_Page.class);
                startActivity(intent9);
            }
        });
    }
}