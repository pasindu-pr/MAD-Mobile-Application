package com.example.dogapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Button_Page extends AppCompatActivity {
  Button button1;
  Button button2;
  Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_page);

        ActionBar actionBar5 = getSupportActionBar();
        actionBar5.setTitle("Choose Changes");
        actionBar5.setDisplayShowHomeEnabled(true);
        actionBar5.setDisplayHomeAsUpEnabled(true);

         button1 = findViewById(R.id.B_button3);
        button2 = findViewById(R.id.B_button4);
        button3 = findViewById(R.id.B_button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(getApplicationContext(), Update_Booking.class);
                startActivity(intent9);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(getApplicationContext(), Delete_Booking.class);
                startActivity(intent9);

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(getApplicationContext(), Calculator.class);
                startActivity(intent9);


            }
        });
    }
}