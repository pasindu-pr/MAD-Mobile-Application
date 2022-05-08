package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobileapplicationdevelopment.dogvio.daycareDatabase.DBDayCareHandler;
import com.mobileapplicationdevelopment.dogvio.daycareDatabase.DayCareModule;

public class Update_Booking extends AppCompatActivity {
   Button updatebutton;
   EditText updatename,updatebreed,updateage,updatein,updateout,updatepack;
    View view;
    private DBDayCareHandler dbDayCareHandler;
    private Context context;
    private Long updateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_booking);
        updatebutton = findViewById(R.id.updatebooking);

        //updatepack = findViewById(R.id.UpdateDog_pa)

        /*action bar*/
        ActionBar actionBar6 = getSupportActionBar();
        actionBar6.setTitle("Update Booking");
        actionBar6.setDisplayShowHomeEnabled(true);
        actionBar6.setDisplayHomeAsUpEnabled(true);

        context = this;
        dbDayCareHandler = new DBDayCareHandler(context);

        updatename = findViewById(R.id.UpdateDog_Name);
        updatebreed = findViewById(R.id.UpdateDog_Breed);
        updateage = findViewById(R.id.UpdateDog_Age);
        updatein = findViewById(R.id.UpdateDog_In);
        updateout = findViewById(R.id.UpdateDog_Out);
        updatepack = findViewById(R.id.UpdatePackgeNo);

        final String id = getIntent().getStringExtra("keyid");

        DayCareModule dayCareModule =  dbDayCareHandler.getsingalBooking(Integer.parseInt(id));

        updatename.setText(dayCareModule.getBedogname());
        updatebreed.setText(dayCareModule.getBedogbreed());
        updateage.setText(dayCareModule.getBedogage());
        updatein.setText(dayCareModule.getBedogin());
        updateout.setText(dayCareModule.getBedogout());
        updatepack.setText(dayCareModule.getBedogpackageno());

        System.out.println(id);

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  updatenameText =  updatename.getText().toString();
                String    updatebreedText = updatebreed.getText().toString();
                String  updateageText = updateage.getText().toString();
                String updateinText = updatein.getText().toString();
                String updateoutText = updateout.getText().toString();
                String updatepackText = updatepack.getText().toString();
                updateDate = System.currentTimeMillis();

                DayCareModule dayCareModule1 = new DayCareModule(Integer.parseInt(id),updatenameText,updatebreedText,updateageText,updateinText,updateoutText
                ,updatepackText,updateDate,0);

                int state = dbDayCareHandler.updatesingleBooking(dayCareModule1);

                startActivity(new Intent(context,ListDayCareAll.class));
                if(state > 0){
                    Toast.makeText(Update_Booking.this,"Updated Booking successfully", Toast.LENGTH_LONG).show();;
                }



            }
        });


    }
    }
