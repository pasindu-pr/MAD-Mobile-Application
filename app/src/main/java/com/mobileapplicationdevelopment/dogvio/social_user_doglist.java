package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class social_user_doglist extends AppCompatActivity {

    FloatingActionButton addSocialDogButton;

    private void onSocialDogButtonClick(){
        Intent intent = new Intent(this, Social_AddDog.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_social_user_doglist);

        addSocialDogButton = findViewById(R.id.floatingActionButton);

        addSocialDogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSocialDogButtonClick();
            }
        });
    }
}