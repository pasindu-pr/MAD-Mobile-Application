package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    Button button1,cal_buttonPack;
    TextView ed_Hours,ed_dates,amount_answer;
    RadioButton rd_pack1,rd_pack2,rd_pack3,rd_pack4;
    private float val;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        /*action bar*/
        ActionBar actionBar9= getSupportActionBar();
        actionBar9.setTitle("Calculator");
        actionBar9.setDisplayShowHomeEnabled(true);
        actionBar9.setDisplayHomeAsUpEnabled(true);

       // button1 = findViewById(R.id.button12);
        cal_buttonPack = findViewById(R.id.cal_buttonPack);
        ed_Hours  = findViewById(R.id.ed_Hours);
        ed_dates = findViewById(R.id.ed_dates);
        rd_pack1=findViewById(R.id.rd_pack1);
        rd_pack2=findViewById(R.id.rd_pack2);
        rd_pack3=findViewById(R.id.rd_pack3);
        rd_pack4=findViewById(R.id.rd_pack4);
        amount_answer = findViewById(R.id.amount_answer);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(getApplicationContext(), Monthly_Memberships.class);
                startActivity(intent7);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cal_buttonPack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {packagePriceAnswers();}
        });

    }

    private void packagePriceAnswers(){
        PackagePrice packagePrice = new PackagePrice();
        String vlaue1 = ed_Hours.getText().toString();
        String vlaue2 = ed_dates.getText().toString();

        if(!vlaue1.matches("[0-9]")){
            Toast.makeText(this , "Enter Numbers For hours Only " , Toast.LENGTH_LONG).show();
        }else if(vlaue1.isEmpty()){
            Toast.makeText(this , "Fill Hours Field " , Toast.LENGTH_LONG).show();
        }else if(vlaue2.isEmpty()){
            Toast.makeText(this , "Fill Date Field " , Toast.LENGTH_LONG).show();
        }else if(!vlaue2.matches("[0-9]")){
            Toast.makeText(this , "Enter Numbers For Date Only" , Toast.LENGTH_LONG).show();
        }else if(vlaue2.isEmpty() && vlaue1.isEmpty()){
            Toast.makeText(this , "Both Field are empty" , Toast.LENGTH_LONG).show();
        }else{
            Float hourValue= Float.parseFloat(vlaue1);
            Float dayValue= Float.parseFloat(vlaue2);

            if(rd_pack1.isChecked()){
                val =  packagePrice.getpackagePriceOne( hourValue,dayValue);
            }else if(rd_pack2.isChecked()){
                val =  packagePrice.getpackagePriceTwo( hourValue,dayValue);
            }else if(rd_pack3.isChecked()){
                val =  packagePrice.getpackagePriceThree( hourValue,dayValue);
            }else if(rd_pack4.isChecked()){
                val=  packagePrice.getpackagePriceFour( hourValue,dayValue);
            }else{
                Toast.makeText(this , "Select the radio button" , Toast.LENGTH_LONG).show();
            }
            amount_answer.setText(new Float(val).toString());
        }

    }
}