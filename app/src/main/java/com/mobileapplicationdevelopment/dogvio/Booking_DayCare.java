package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobileapplicationdevelopment.dogvio.daycareDatabase.DBHelper;

public class Booking_DayCare extends AppCompatActivity {
    Button button4;
    private EditText Bedogname, Bedogbreed,Bedogage, Bedogin,Bedogout,Bedogpackageno;
    private Button addbooking;
    //private DBHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_day_care);

        /*action bar*/
        ActionBar actionBar4 = getSupportActionBar();
        actionBar4.setTitle("DayCare Booking");
        actionBar4.setDisplayShowHomeEnabled(true);
        actionBar4.setDisplayHomeAsUpEnabled(true);

        /*pass varibles*/
        Bedogname = findViewById(R.id.Dog_Name);
        Bedogbreed = findViewById(R.id.Dog_Breed);
        Bedogage= findViewById(R.id.Dog_Age);
        Bedogin= findViewById(R.id.Dog_In);
        Bedogout= findViewById(R.id.Dog_Out);
        Bedogpackageno = findViewById(R.id.Dog_PackageNo);
        context = this;
        addbooking = findViewById(R.id.addBooking);



    }


    public void saveBooking(View view){
        String bdname = Bedogname.getText().toString();
        String bdbreed = Bedogbreed.getText().toString();
        String bdage = Bedogage.getText().toString();
        String bdin = Bedogin.getText().toString();
        String bdout = Bedogout.getText().toString();
        String bdpackageno = Bedogpackageno.getText().toString();
        DBHelper dbhelper = new DBHelper(this);

        if(bdbreed.isEmpty() || bdname.isEmpty()){
            Toast.makeText(this, "Enter values" , Toast.LENGTH_LONG).show();
        }else{
            long inserted = dbhelper.addBooking(bdname,bdbreed,bdage,bdin,bdout,bdpackageno);

            if(inserted >0){
                Toast.makeText(this, "Data inserted successfully" , Toast.LENGTH_LONG).show();

                addbooking.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,DisplayBooking.class);
                        intent.putExtra("Keydogname",bdname);
                        intent.putExtra("Keydogbreed",bdbreed);
                        intent.putExtra("Keydogage",bdage);
                        intent.putExtra("Keydogin",bdin);
                        intent.putExtra("Keydogout",bdout);
                        intent.putExtra("Keydogpack",bdpackageno);
                        startActivity(intent);

                       /* Intent intent1 = new Intent(context,Update_Booking.class);
                        intent1.putExtra("Keydogname1",bdname);
                        intent1.putExtra("Keydogbreed1",bdbreed);
                        intent1.putExtra("Keydogage1",bdage);
                        intent1.putExtra("Keydogin1",bdin);
                        intent1.putExtra("Keydogout1",bdout);
                        intent1.putExtra("Keydogpack1",bdpackageno);

                        startActivity(intent1);
*/
                    }


                });
            }else {
                Toast.makeText(this, "Something went wrrong" , Toast.LENGTH_LONG).show();
            }
        }
    }


}