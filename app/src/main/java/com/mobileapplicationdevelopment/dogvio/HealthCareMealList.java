package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobileapplicationdevelopment.dogvio.HealthCareMealDB.DBHealthCareHandler;
import com.mobileapplicationdevelopment.dogvio.HealthCareMealDB.HealthCareAdapter;
import com.mobileapplicationdevelopment.dogvio.HealthCareMealDB.HealthCareMealModule;

import java.util.ArrayList;
import java.util.List;

public class HealthCareMealList extends AppCompatActivity {
    private Button  addnewMeal;
    private TextView count;
    private ListView listView;
    DBHealthCareHandler dbHealthCareHandler;
    Context context;

    private List<HealthCareMealModule> healthCareMealModules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_meal_list);

        context = this;

        dbHealthCareHandler = new DBHealthCareHandler(context);
        addnewMeal = findViewById(R.id.addnewmeal);
        count = findViewById(R.id.noofmeal);
        listView = findViewById(R.id.bookinglist);
        healthCareMealModules = new ArrayList<>();

        healthCareMealModules = dbHealthCareHandler.getAllMeals();
        HealthCareAdapter healthCareAdapter = new HealthCareAdapter(context, R.layout.activity_health_care_single_meal, healthCareMealModules);
        listView.setAdapter(healthCareAdapter);

        //get count
        int countMeal = dbHealthCareHandler.countMeal();
        count.setText(" You Have " + countMeal + " meals history");

        addnewMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, HealthCare_MealList_Add.class));
            }
        });


        //Dialog Box
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                HealthCareMealModule healthCareMealModule =  healthCareMealModules.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Meal Shedule Changes");
                //builder.setTitle(healthCareMealModule.getMorningmeal());
                //builder.setTitle(healthCareMealModule.getNoonmeal());
               // builder.setTitle(healthCareMealModule.getNigthmeal());
                //builder.setTitle(healthCareMealModule.getDaymeal());

                //builder.setMessage("Message");


                /*finished button*/
                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                            startActivity(new Intent(context,HealthCareMealList.class));

                    }
                });
                /*update button*/
                builder.setNeutralButton("Update Meal Schedule", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int  which) {
                                Intent intent = new Intent(context, HealthCare_MealList_Modify.class);
                                intent.putExtra("keyid",String.valueOf(healthCareMealModule.getId()));
                                startActivity(intent);

                    }
                });


                /*delete button*/
                builder.setNegativeButton("Delete Meal Schedule", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int  which) {
                        dbHealthCareHandler.deleteMeal(healthCareMealModule.getId());
                        startActivity(new Intent(context,HealthCareMealList.class));
                        Toast.makeText(HealthCareMealList.this,"Delete successfully" ,Toast.LENGTH_LONG);

                    }
                });
                builder.show();
            }

        });

        ActionBar actionBar4 = getSupportActionBar();
        actionBar4.setTitle("My Meal List");
        actionBar4.setDisplayShowHomeEnabled(true);
        actionBar4.setDisplayHomeAsUpEnabled(true);


    }
}