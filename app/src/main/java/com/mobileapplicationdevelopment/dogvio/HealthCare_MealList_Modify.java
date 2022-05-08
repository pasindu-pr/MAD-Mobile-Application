package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobileapplicationdevelopment.dogvio.HealthCareMealDB.DBHealthCareHandler;
import com.mobileapplicationdevelopment.dogvio.HealthCareMealDB.HealthCareMealModule;

public class HealthCare_MealList_Modify extends AppCompatActivity {

      EditText Umorning,Unoon,Unight,Uday;
      Button updateButton;
      private DBHealthCareHandler dbHealthCareHandler;
      private Context context;
      private Long updatedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_meal_list_modify);



        Umorning = findViewById(R.id.modify_editmorning);
        Unoon = findViewById(R.id.modify_editnoon);
        Unight = findViewById(R.id.modify_editnight);
        Uday = findViewById(R.id.modify_editday);
        updateButton = findViewById(R.id.btn_modify_modify);

        ActionBar actionBar4 = getSupportActionBar();
        actionBar4.setTitle("Modify My Meal");
        actionBar4.setDisplayShowHomeEnabled(true);
        actionBar4.setDisplayHomeAsUpEnabled(true);

        context = this;
        dbHealthCareHandler = new DBHealthCareHandler(context);

        final String  id = getIntent().getStringExtra("keyid");
        HealthCareMealModule healthCareMealModule = dbHealthCareHandler.getsingalMeal(Integer.parseInt(id));

        Umorning.setText(healthCareMealModule.getMorningmeal());
        Unoon.setText(healthCareMealModule.getNoonmeal());
        Unight.setText(healthCareMealModule.getNigthmeal());
        Uday.setText(healthCareMealModule.getDaymeal());
        //System.out.println(id);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  updatmorning =  Umorning.getText().toString();
                String    updatenoon = Unoon.getText().toString();
                String  updatenigth = Unight.getText().toString();
                String  updateday = Uday.getText().toString();
                updatedDate = System.currentTimeMillis();

                HealthCareMealModule healthCareMealModule1 = new HealthCareMealModule(Integer.parseInt(id),updatmorning,updatenoon,updatenigth,updateday,
                        updatedDate,0);

                int state = dbHealthCareHandler.updatesingleBooking(healthCareMealModule1);

                startActivity(new Intent(context,HealthCareMealList.class));
                if(state > 0){
                    Toast.makeText(HealthCare_MealList_Modify.this,"Updated successfully", Toast.LENGTH_LONG).show();;
                }
            }
        });

    }
}