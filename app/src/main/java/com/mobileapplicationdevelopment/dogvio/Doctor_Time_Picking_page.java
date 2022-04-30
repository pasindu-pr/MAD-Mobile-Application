package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class Doctor_Time_Picking_page extends AppCompatActivity {

    private EditText DogCount;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private Button timeButton;
    private Bundle savedInstanceState;
    private Button saveButton;
    private String date ;
    private String appointmentTime;
    private String Drname;
    ;

    public void redirect() {
        Intent intent = new Intent(this,Doctor_Time_Picking_data_page.class);
        intent.putExtra("date", date);
        intent.putExtra("time", appointmentTime);
        intent.putExtra("nDrName" ,Drname );
        intent.putExtra("DogCount" ,DogCount.getText().toString());
        startActivity(intent);
    }


    //On Crate method-------------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_time_picking_page);
        initDatePicker();


        DogCount = (EditText)findViewById(R.id.doc_dog_counta1);
        dateButton = findViewById(R.id.datePickerButton);
        timeButton = findViewById(R.id.timeButton);
        saveButton = findViewById(R.id.date_time_save_button);

        //**********************************************************
        Drname = getIntent().getStringExtra ("DrName");
        TextView textVD = findViewById(R.id.Dr_Booked_Name);
        textVD.setText(Drname);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirect();
            }
        });


        ActionBar DocActionBar6 = getSupportActionBar();
        DocActionBar6.setTitle("Place Appointment");
        DocActionBar6.setDisplayShowHomeEnabled(true);
        DocActionBar6.setDisplayHomeAsUpEnabled(true);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------
    private Bundle initDatePicker()
    {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                date = makeDateString(day, month, year);
                dateButton.setText(date);
                //*********************************************************

            }

        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        return null;
    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";
        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.setTitle("Select Date");
        datePickerDialog.show();
    }




    //Time Button


    int hour, minute;


    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {

            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
                appointmentTime = String.format(Locale.getDefault(), "%02d:%02d",hour, minute);
                timeButton.setText(appointmentTime);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, /*style,*/ onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

}