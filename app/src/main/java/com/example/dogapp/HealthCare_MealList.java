package com.example.dogapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthCare_MealList extends AppCompatActivity {

    Button button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_meal_list);

        ActionBar actionBar4 = getSupportActionBar();
        actionBar4.setTitle("Meal List");
        actionBar4.setDisplayShowHomeEnabled(true);
        actionBar4.setDisplayHomeAsUpEnabled(true);

        button4 = findViewById(R.id.btn_updatemeal);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), HealthCare_MealList_Modify.class);
                startActivity(intent1);
            }
        });

        button5 = findViewById(R.id.btn_addmeal);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), HealthCare_MealList_Add.class);
                startActivity(intent1);
            }
        });
    }
}