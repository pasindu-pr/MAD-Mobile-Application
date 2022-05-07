package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mobileapplicationdevelopment.dogvio.database.DbHandler;

public class HealthCare_MealList_Edit extends AppCompatActivity {

    private EditText morning,noon,night,day;
    private Button edit;
    private DbHandler dbHandler;
    private Context context;
    private Long updateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_meal);

        context = this;
        dbHandler = new DbHandler(context);

        morning = findViewById(R.id.editToDoTextMorning);
        noon = findViewById(R.id.editToDoTextNoon);
        night = findViewById(R.id.editTextNight);
        day = findViewById(R.id.editTextDay);
        edit = findViewById(R.id.buttonEdit);

        final String id = getIntent().getStringExtra("id");
        HealthCare_ToMeal tomeal = dbHandler.getSingleToDo(Integer.parseInt(id));

        morning.setText(tomeal.getMorning());
        noon.setText(tomeal.getNoon());
        night.setText(tomeal.getNight());
        day.setText(tomeal.getDay());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String morningText = morning.getText().toString();
                String noonText = morning.getText().toString();
                String nightText = morning.getText().toString();
                String dayText = morning.getText().toString();
                updateDate = System.currentTimeMillis();

                HealthCare_ToMeal healthCareToMeal = new HealthCare_ToMeal(Integer.parseInt(id),morningText,noonText,nightText,dayText,updateDate,0);
                int state = dbHandler.updateSingleToDo(healthCareToMeal);
                System.out.println(state);
                startActivity(new Intent(context,HealthCare_MealNew.class));
            }
        });
    }
}