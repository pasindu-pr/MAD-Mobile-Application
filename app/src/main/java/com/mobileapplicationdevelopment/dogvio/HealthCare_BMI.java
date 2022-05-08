package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class HealthCare_BMI extends AppCompatActivity {

    private Float bmi;
    EditText et_age;
    EditText et_height;
    EditText et_weight;
    RadioButton rd_btn_male;
    RadioButton rd_btn_female;
    Button btn_bmicalc, welcome;
    TextView tv_answer;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_bmi);

        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        rd_btn_male = findViewById(R.id.rd_btn_male);
        rd_btn_female = findViewById(R.id.rd_btn_female);
        btn_bmicalc = findViewById(R.id.btn_bmicalc);
        tv_answer = findViewById(R.id.tv_answer);
        welcome = findViewById(R.id.bmiwelcome);
        context = this;

        ActionBar actionBar2 = getSupportActionBar();
        actionBar2.setTitle("BMI");
        actionBar2.setDisplayShowHomeEnabled(true);
        actionBar2.setDisplayHomeAsUpEnabled(true);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,HealthCare_Welcome.class));
            }
        });


    }


    @Override
    protected  void onResume(){
        super.onResume();
        btn_bmicalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer(){

        HealthCare_BMI_Calc cal = new HealthCare_BMI_Calc();
        String value1 = et_height.getText().toString();
        String value2 = et_weight.getText().toString();

        if(TextUtils.isEmpty(value1)){
            Toast.makeText(this, "Enter the height!", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(value2)){
            Toast.makeText(this, "Enter the weight!", Toast.LENGTH_SHORT).show();
        }else {
            Float bmi1 = Float.parseFloat(value1);
            Float bmi2 = Float.parseFloat(value2);

            if(rd_btn_male.isChecked()){
                bmi = cal.maleBmi(bmi1,bmi2);
            }else if(rd_btn_female.isChecked()){
                bmi = cal.femaleBmi(bmi1,bmi2);
            }else{
                Toast.makeText(this, "Select the radio button!", Toast.LENGTH_SHORT).show();
            }

            tv_answer.setText(new Float(bmi).toString());
        }


    }
}