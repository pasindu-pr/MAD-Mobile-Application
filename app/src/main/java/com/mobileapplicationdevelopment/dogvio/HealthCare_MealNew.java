package com.mobileapplicationdevelopment.dogvio;

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

import com.mobileapplicationdevelopment.dogvio.database.DbHandler;

import java.util.ArrayList;
import java.util.List;

public class HealthCare_MealNew extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private TextView count;
    Context context;
    private DbHandler dbHandler;
    private List<HealthCare_ToMeal> healthCareToMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_meal_new);
        context = this;

        dbHandler = new DbHandler(context);
        add = findViewById(R.id.add);
        listView = findViewById(R.id.tomeallist);
        count = findViewById(R.id.tomealcount);
        healthCareToMeals = new ArrayList<>();

        healthCareToMeals = dbHandler.getAllToDos();

        HealthCare_ToMealAdapter adapter = new HealthCare_ToMealAdapter(context,R.layout.single_tomeal, healthCareToMeals);

        listView.setAdapter(adapter);

        //get todo counts from the table
        int countTodo = dbHandler.countToDo();
        count.setText("You have "+countTodo+" todos");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, HealthCare_MealList_Add.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final HealthCare_ToMeal todo = healthCareToMeals.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(todo.getMorning());
                builder.setMessage(todo.getNoon());
                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        todo.setFinished(System.currentTimeMillis());
                        dbHandler.updateSingleToDo(todo);
                        startActivity(new Intent(context,HealthCare_MealNew.class));
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deleteToDo(todo.getId());
                        startActivity(new Intent(context,HealthCare_MealNew.class));
                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, HealthCare_MealList_Edit.class);
                        intent.putExtra("id",String.valueOf(todo.getId()));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });

    }
}