package com.mobileapplicationdevelopment.dogvio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Doctor_Appointment_Adaptor extends ArrayAdapter<Doctor_Appointment_Model_Class> {

    private Context context;
    private int resource;
    List<Doctor_Appointment_Model_Class> Appointments;

    Doctor_Appointment_Adaptor(Context context , int resource, List<Doctor_Appointment_Model_Class> Appointments){
        super(context,resource,Appointments);
        this.context = context;
        this.resource = resource;
        this.Appointments = Appointments;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView DrOwner = row.findViewById(R.id.Owner_Name);
        TextView DrName = row.findViewById(R.id.Doc_Name);
        TextView DrDate = row.findViewById(R.id.Doc_Date);
        TextView DrTime = row.findViewById(R.id.Doc_Time);
        TextView DrDogCount = row.findViewById(R.id.Doc_Dog_Count);

        //Appointment
        Doctor_Appointment_Model_Class appointment = Appointments.get(position);
        DrOwner.setText(appointment.getUserName());
        DrName.setText(appointment.getDrName());
        DrTime.setText(appointment.getTime());
        DrDate.setText(appointment.getDate());
        DrDogCount.setText(appointment.getDogCount());

        return row;
    }
}
