package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Locale;




public class Doctor_Edit_Appontment extends AppCompatActivity {

    private EditText DogCount;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private Button timeButton;
    private Button editButton;
    private String date ;
    private EditText userName;
    private TextView docName;
    private String appointmentTime;
    private Doc_DbHandler doc_dbHandler1;
    private Context context;
    private long updatedTime;
    String dateTxt;
    String timeTxt;
    String docTxt;
    String  userNametxt;
    String dogCountTxt;

    public void DisplayToast2(View view){
       //Toasty.error(this,"Changes are saved",Toast.LENGTH_SHORT).show();
       Toast.makeText(Doctor_Edit_Appontment.this,"Changes are saved",Toast.LENGTH_SHORT).show();

    }
    //On Crate method-------------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_edit_appontment);
        initDatePicker();

        context = this;
        doc_dbHandler1 = new Doc_DbHandler(context);

        DogCount = (EditText)findViewById(R.id.doc_dog_counta1_Edit);
        dateButton = findViewById(R.id.datePickerButton_Edit);
        timeButton = findViewById(R.id.timeButton_Edit);
        editButton = findViewById(R.id.date_time_save_button_Edit);
        userName = findViewById(R.id.doc_dog_user_name_Edit);
        docName = findViewById(R.id.Dr_Booked_Name_Edit);

        final String id = getIntent().getStringExtra("id");
        Doctor_Appointment_Model_Class Doc_Appoint =  doc_dbHandler1.getSingleAppointment(Integer.parseInt(id));
        DogCount.setText(Doc_Appoint.getDogCount());
        dateButton.setText(Doc_Appoint.getDate());
        timeButton.setText(Doc_Appoint.getTime());
        userName.setText(Doc_Appoint.getUserName());
        docName.setText(Doc_Appoint.getDrName());

//        System.out.println(id);
        //**********************************************************


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                redirect();
                timeTxt = timeButton.getText().toString();
                dateTxt = dateButton.getText().toString();
                docTxt = docName.getText().toString();
                userNametxt = userName.getText().toString();
                dogCountTxt = DogCount.getText().toString();

                Doctor_Appointment_Model_Class doc_Appoit_Model = new Doctor_Appointment_Model_Class(Integer.parseInt(id),dateTxt,timeTxt,docTxt,dogCountTxt,userNametxt);
               int state = doc_dbHandler1.updateAppointment(doc_Appoit_Model);
                startActivity(new Intent(context,doc_all_appointment.class));
                DisplayToast2(view);
            }
        });






        ActionBar DocActionBar7 = getSupportActionBar();
        DocActionBar7.setTitle("Edit Appointment");
        DocActionBar7.setDisplayShowHomeEnabled(true);
        DocActionBar7.setDisplayHomeAsUpEnabled(true);
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