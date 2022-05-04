package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobileapplicationdevelopment.dogvio.daycareDatabase.DBHelper;

public class DisplayBooking extends AppCompatActivity {

    Button calculator, update, delete;
    private TextView getdogname, getdogbreed,getdogage, getdogin,getdogout,getdogpackageno;
    private DBHelper dbhelper;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_booking);

        /*action bar*/
        ActionBar actionBar5 = getSupportActionBar();
        actionBar5.setTitle("Display Booking");
        actionBar5.setDisplayShowHomeEnabled(true);
        actionBar5.setDisplayHomeAsUpEnabled(true);

        calculator = findViewById(R.id.calculator);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        /*create variables*/
        getdogname= findViewById(R.id.Dog_Name);
        getdogbreed = findViewById(R.id.Dog_Breed);
        getdogage = findViewById(R.id.Dog_Age);
        getdogin = findViewById(R.id.Dog_In);
        getdogout = findViewById(R.id.Dog_Out);
        getdogpackageno = findViewById(R.id.Dog_PackageNo);

        String dogname1 = getIntent().getStringExtra("Keydogname");
        String dogbreed1 = getIntent().getStringExtra("Keydogbreed");
        String dogage1 = getIntent().getStringExtra( "Keydogage");
        String dogin1 = getIntent().getStringExtra("Keydogin");
        String dogout1 = getIntent().getStringExtra("Keydogout");
        String dogpack1 = getIntent().getStringExtra("Keydogpack");

        /*pass data to text view*/
        TextView daycaredogname = findViewById(R.id.ddname);
        TextView daycaredogbreed = findViewById(R.id.ddbreed);
        TextView daycaredogage = findViewById(R.id.ddage);
        TextView daycaredogin = findViewById(R.id.dddogin);
        TextView daycaredogout = findViewById(R.id.dddogout);
        TextView daycaredogpack= findViewById(R.id.ddpackageno);

        /*set text values*/
        daycaredogname.setText(dogname1);
        daycaredogbreed.setText(dogbreed1);
        daycaredogage.setText(dogage1);
        daycaredogin.setText(dogin1);
        daycaredogout.setText(dogout1);
        daycaredogpack.setText(dogpack1);


       calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(getApplicationContext(),Calculator.class);
                startActivity(intent9);

            }
        });



        /*    update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,Update_Booking.class);
                    intent.putExtra("Keydogname1",dogname1);
                    intent.putExtra("Keydogbreed1",dogbreed1);
                    intent.putExtra("Keydogage1",dogage1);
                    intent.putExtra("Keydogin1",dogin1);
                    intent.putExtra("Keydogout1", dogout1);
                    intent.putExtra("Keydogpack1",dogpack1);
                    startActivity(intent);
                }

            });
*/


    }
}