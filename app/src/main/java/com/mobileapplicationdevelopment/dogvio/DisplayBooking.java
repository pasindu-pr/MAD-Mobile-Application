package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayBooking extends AppCompatActivity {

    Button buttonpage;
    private EditText getdogname, getdogbreed,getdogage, getdogin,getdogout,getdogpackageno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_booking);

        /*action bar*/
        ActionBar actionBar5 = getSupportActionBar();
        actionBar5.setTitle("Display Booking");
        actionBar5.setDisplayShowHomeEnabled(true);
        actionBar5.setDisplayHomeAsUpEnabled(true);

        buttonpage = findViewById(R.id.displaybutton);

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

        buttonpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(getApplicationContext(), Button_Page.class);
                startActivity(intent9);

            }
        });
    }
}