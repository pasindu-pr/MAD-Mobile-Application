package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Doctor_Time_Picking_data_page extends AppCompatActivity {
    //String dogCount;
//Float pay;
    int result ;
    // private String result= getIntent().;

    public void redirect() {
        Intent intent1 = new Intent( this,Doctor_Appoinment_payment.class);
        intent1.putExtra("pay", result);
        startActivity(intent1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_time_picking_data_page);

        ActionBar DocActionBar5 = getSupportActionBar();
        DocActionBar5.setTitle("Appointment Details");
        DocActionBar5.setDisplayShowHomeEnabled(true);
        DocActionBar5.setDisplayHomeAsUpEnabled(true);

        Button Button1a = findViewById(R.id.doc_page4_btn1);
        Button Button2a = findViewById(R.id.doc_page4_btn2);
        Button Button3a = findViewById(R.id.doc_page4_btn3);
        Dialog nDialog = new Dialog(this);


        Intent intent = getIntent();

        String Drname = getIntent().getStringExtra ("nDrName");
        TextView textVD = findViewById(R.id.doc_page4_text1a);
        textVD.setText(Drname);

        String dogCount = getIntent().getStringExtra ("DogCount");
        TextView textDC = findViewById(R.id.doc_page4_text4a);
        textDC.setText(dogCount);

        String date = getIntent().getStringExtra ("date");
        TextView textV = findViewById(R.id.doc_page4_text2a);
        textV.setText(date);

        String appointmentTime = getIntent().getStringExtra ("time");
        TextView textV2 = findViewById(R.id.doc_page4_text3a2);
        textV2.setText(appointmentTime);




        Button2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Doctor_Time_Picking_data_page.this,Doctor_Time_Picking_page.class);
                startActivity(intent2);
            }
        });

        Button3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nDialog.setContentView(R.layout.activity_doctor_delete_popup_msg);
                nDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Intent intent3 = new Intent(Doctor_Time_Picking_data_page.this,Doctor_delete_popup_msg.class);
                startActivity(intent3);
            }
        });
    }
    public int mult(View view){
        TextView Txt1 = (TextView)findViewById(R.id.doc_page4_text4a);
        int n1 = Integer.parseInt(Txt1.getText().toString());
        result = n1 * 500 ;
        redirect();
        return result;
    }
}