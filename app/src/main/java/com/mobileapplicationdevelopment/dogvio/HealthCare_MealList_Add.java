package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mobileapplicationdevelopment.dogvio.HealthCareMealDB.DBHealthCareHandler;
import com.mobileapplicationdevelopment.dogvio.HealthCareMealDB.HealthCareMealModule;

public class HealthCare_MealList_Add extends AppCompatActivity {
    TextView addmorning, addnoon, addnight, addday;
    Button   addmeal;
    //private DBHandler dbHandler;
    private DBHealthCareHandler dbHealthCareHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_meal_list_add);

        //action bar
        ActionBar actionBar4 = getSupportActionBar();
        actionBar4.setTitle("Add My Meal");
        actionBar4.setDisplayShowHomeEnabled(true);
        actionBar4.setDisplayHomeAsUpEnabled(true);

        //pass variables
        addmorning = findViewById(R.id.add_editmorning);
        addnoon = findViewById(R.id.add_editnoon);
        addnight = findViewById(R.id.add_editnight);
        addday = findViewById(R.id.add_editday);
        addmeal = findViewById(R.id.btn_add_meal);//add meal button
        context =  this;

        dbHealthCareHandler = new DBHealthCareHandler(context);

        addmeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        String Maddmorning = addmorning.getText().toString();
                        String Maddnoon =addnoon.getText().toString();
                        String Maddnight =addnight.getText().toString();
                        String Maddday = addday.getText().toString();
                        long started = System.currentTimeMillis();

                if(TextUtils.isEmpty(Maddmorning)){
                    Toast.makeText(context, "Please Enter Morning Meal", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(Maddnoon)){
                    Toast.makeText(context, "Please Enter Noon Meal", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(Maddnight)){
                    Toast.makeText(context, "Please Enter Night Meal", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(Maddday)){
                    Toast.makeText(context, "Fill The Day Field", Toast.LENGTH_SHORT).show();
                }else
                {
                    HealthCareMealModule healthCareMealModule = new HealthCareMealModule(Maddmorning, Maddnoon, Maddnight, Maddday,
                            started, 0);


                    dbHealthCareHandler.addmeal(healthCareMealModule);

                    startActivity(new Intent(context, HealthCareMealList.class));

                }

            }


        });
    }
}