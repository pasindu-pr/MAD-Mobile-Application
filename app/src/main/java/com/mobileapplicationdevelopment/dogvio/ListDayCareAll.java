package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mobileapplicationdevelopment.dogvio.daycareDatabase.BookingAddapter;
import com.mobileapplicationdevelopment.dogvio.daycareDatabase.DBDayCareHandler;
import com.mobileapplicationdevelopment.dogvio.daycareDatabase.DayCareModule;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListDayCareAll extends AppCompatActivity {
    private Button addnew;
    private ListView listview;
    private TextView countbooking;
    Context context;
    private DBDayCareHandler  dbdaycarehandler;
    private List<DayCareModule>  dayCareModules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_day_care_all);
        context = this;
        dbdaycarehandler = new DBDayCareHandler(context);

        addnew = findViewById(R.id.addnewbooking);
        listview = findViewById(R.id.bookinglist);
        countbooking =findViewById(R.id.noofbooking);
        dayCareModules = new ArrayList<>();

        dayCareModules = dbdaycarehandler.getAllBookingHistory();


        BookingAddapter addapter = new BookingAddapter(context,R.layout.activity_day_care_booking_history,dayCareModules);

        listview.setAdapter(addapter);

        //get booking count from table

        int countBooking = dbdaycarehandler.countBooking();
        countbooking.setText(" You have " + countBooking+ " booking before");


    }
}