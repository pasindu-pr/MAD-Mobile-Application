package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mobileapplicationdevelopment.dogvio.database.DbHandler;

public class HealthCare_MealList_Add extends AppCompatActivity {

    private EditText morning, noon, night, day;
    private Button add;
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_meal);

        morning = findViewById(R.id.editTextMorning);
        noon = findViewById(R.id.editTextNoon);
        night = findViewById(R.id.editTextNight);
        day = findViewById(R.id.editTextDay);
        add = findViewById(R.id.buttonAdd);
        context = this;

        dbHandler = new DbHandler(context);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mealMorning = morning.getText().toString();
                String mealNoon = noon.getText().toString();
                String mealNight = night.getText().toString();
                String mealDay = day.getText().toString();
                long started = System.currentTimeMillis();

                HealthCare_ToMeal healthCareToMeal = new HealthCare_ToMeal(mealMorning,mealNoon,mealNight,mealDay,started,0);
                dbHandler.addToDo(healthCareToMeal);

                startActivity(new Intent(context,HealthCare_MealNew.class));
            }
        });
    }
}