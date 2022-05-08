package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.GenericArrayType;
import java.util.Calendar;
import java.util.Locale;

public class Doctor_Time_Picking_page extends AppCompatActivity {
    private EditText DogCount;
    private EditText userName;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private Button timeButton;
    private Button saveButton;
    private String date ;
    private String appointmentTime;
    private String Drname;
    private String dogcount;
    private String dgcount;
    private String Uname;
    private String uname;
    private Doc_DbHandler doc_dbHandler;
    private Context context;


    public void myToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.doc_custom_tost_a, (ViewGroup) findViewById(R.id.Doc_tost_a));
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    public void redirect() {
        Intent intent = new Intent(this,Doctor_Time_Picking_data_page.class);
        intent.putExtra("date", date);
        intent.putExtra("time", appointmentTime);
        intent.putExtra("nDrName" ,Drname );
        dgcount = DogCount.getText().toString();
        Uname = userName.getText().toString();
        intent.putExtra("dogCount" ,dgcount);
        intent.putExtra("USerName" ,Uname);

        if(Uname.isEmpty()){
            userName.setError("User Name is Required");
        }else if (dgcount.isEmpty()){
            DogCount.setError("Dog Count is Required");
        }else if(date.isEmpty()){
            dateButton.setError("Date is Required");
        }else if(appointmentTime.isEmpty()){
            timeButton.setError("Time is Required");
        }else {
            dogcount = DogCount.getText().toString();
            uname = userName.getText().toString();
            Doctor_Appointment_Model_Class Doc_Model_class = new Doctor_Appointment_Model_Class(date, appointmentTime, Drname, dogcount, uname);
            doc_dbHandler.addApointment(Doc_Model_class);

            myToast();
            startActivity(intent);

        }
    }

    //On Crate method-------------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_time_picking_page);
        initDatePicker();

        DogCount = findViewById(R.id.doc_dog_counta1);
        userName =  findViewById(R.id.doc_dog_user_name);
        dateButton = findViewById(R.id.datePickerButton);
        timeButton = findViewById(R.id.timeButton);
        saveButton = findViewById(R.id.date_time_save_button);

        context=this;
        doc_dbHandler = new Doc_DbHandler(context);

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