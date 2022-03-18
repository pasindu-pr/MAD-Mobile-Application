package com.mobileapplicationdevelopment.dogvio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    private AppCompatButton loginButton;
    private TextView notRegisteredText;

    private void onLoginButtonClick () {
        Intent intent = new Intent(this, NavigationPage.class);
        startActivity(intent);
    }

    private void notRegisteredTextClick () {
        Intent intent = new Intent(this, RegistrationPage.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_login_page);

        loginButton = (AppCompatButton) findViewById(R.id.loginButton);
        notRegisteredText = (TextView) findViewById(R.id.notRegisteredText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginButtonClick();
            }
        });

        notRegisteredText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notRegisteredTextClick();
            }
        });

    }
}