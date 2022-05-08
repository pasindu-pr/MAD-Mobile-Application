package com.mobileapplicationdevelopment.dogvio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    private AppCompatButton loginButton;
    private TextView notRegisteredText;
    private EditText loginEmail;
    private  EditText loginPassword;
    private FirebaseAuth mAuth;

    private void onLoginButtonClick (String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LoginPage.this, NavigationPage.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginPage.this, "Login not successfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
        loginEmail = findViewById(R.id.loginPageEmailInput);
        loginPassword = findViewById(R.id.loginPagePasswordInput);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginButtonClick(loginEmail.getText().toString(), loginPassword.getText().toString());
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