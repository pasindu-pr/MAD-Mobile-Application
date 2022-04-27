package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Social_DogsList extends AppCompatActivity {

    CardView dogListCart;

    private void onDogListCardClick(){
        Intent intent = new Intent(this, Social_DogDetails.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_social_dogs_list);


        dogListCart = findViewById(R.id.socialDogCard);
        dogListCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDogListCardClick();
            }
        });

    }
}