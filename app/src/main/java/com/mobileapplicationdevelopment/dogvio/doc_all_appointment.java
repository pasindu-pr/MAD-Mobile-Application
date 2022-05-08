package com.mobileapplicationdevelopment.dogvio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class doc_all_appointment extends AppCompatActivity {

   private ListView listview;
   private TextView count;
   Context context;
   private List<Doctor_Appointment_Model_Class> appointments;

   private Doc_DbHandler doc_dbHandler;

    public void myToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.doc_custom_toast_b, (ViewGroup) findViewById(R.id.Doc_tost_b));
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_all_appointment);

        ActionBar DocActionBar1 = getSupportActionBar();
        DocActionBar1.setTitle("All Appointments");
        DocActionBar1.setDisplayShowHomeEnabled(true);
        DocActionBar1.setDisplayHomeAsUpEnabled(true);

        context = this;
        doc_dbHandler = new Doc_DbHandler(context);
        listview = findViewById(R.id.doc_appoin_list);
        count = findViewById(R.id.appoin_count);
        appointments = new ArrayList<>();
       appointments = doc_dbHandler.getAllAppointments();

       Doctor_Appointment_Adaptor adaptor = new Doctor_Appointment_Adaptor(context,R.layout.doc_single_appoi,appointments);
        listview.setAdapter(adaptor);
        //get Appointment count from the table
        int countAppointment = doc_dbHandler.countAppointment();
        count.setText("You have "+countAppointment+" Appointments");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Doctor_Appointment_Model_Class doc_appointment_model_class = appointments.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("What do you want to do to this Appointment ?");
                builder.setMessage(doc_appointment_model_class.getUserName());
                builder.show();
                builder.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(context,doc_all_appointment.class));
                    }
                });
                builder.setNeutralButton("DELETE APPOINTMENT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        doc_dbHandler.deleteAppointment(doc_appointment_model_class.getId());
                        myToast();
                        startActivity(new Intent(context,doc_all_appointment.class));
                    }
                });

                builder.setNegativeButton("EDIT APPOINTMENT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context,Doctor_Edit_Appontment.class);
                        intent.putExtra("id",String.valueOf(doc_appointment_model_class.getId()));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });

    }


}