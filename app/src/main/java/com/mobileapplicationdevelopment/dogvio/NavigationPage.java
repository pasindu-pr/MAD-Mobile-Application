package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NavigationPage extends AppCompatActivity {
    private TextView navBarSocialText;
    private  TextView socializedPetsText;
    private TextView dayCarePetsText;
    private  TextView healthCare;
    private TextView doctorBooking;

    private void onNavBarSocialTextClick() {
        Intent intent = new Intent(this, Social_DogsList.class);
        startActivity(intent);
    }

    private void onSocializedPetsText() {
        Intent intent = new Intent(this, social_user_doglist.class);
        startActivity(intent);
    }

    public void onDaycareHomepageClick() {
        Intent intent = new Intent(this, Daycare_Homepage.class);
        startActivity(intent);
    }

    public void onHealthcareHomepageClick() {
        Intent intent = new Intent(this, HealthCare_Welcome.class);
        startActivity(intent);
    }


    public  void onDoctoreBookingClick() {
        Intent intent = new Intent(this, Doctor_Booking_main.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_navigation_page);

        navBarSocialText = (TextView) findViewById(R.id.navBarSocialPets);
        socializedPetsText = (TextView) findViewById(R.id.socializedPets);
        dayCarePetsText = (TextView) findViewById(R.id.dayCare);
        healthCare = (TextView) findViewById(R.id.healthCare);
        doctorBooking = (TextView) findViewById(R.id.doctorBooking);

        navBarSocialText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNavBarSocialTextClick();
            }
        });

        socializedPetsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSocializedPetsText();
            }
        });

        dayCarePetsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDaycareHomepageClick();
            }
        });


        healthCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onHealthcareHomepageClick();
            }
        });


        doctorBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDoctoreBookingClick();
            }
        });

    }
}