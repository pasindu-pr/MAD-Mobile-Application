package com.mobileapplicationdevelopment.dogvio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationPage extends AppCompatActivity {

    EditText userName;
    EditText userPassword;
    EditText userEmail;
    AppCompatButton submitButton;
    private FirebaseAuth mAuth;

    private void authenticateUser(String name, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), NavigationPage.class);
                            startActivity(intent);
                        } else {
                            Log.w("User Regitration", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegistrationPage.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_registration_page);
        mAuth = FirebaseAuth.getInstance();

        userName = findViewById(R.id.registrationpageusernameinput);
        userEmail = findViewById(R.id.registrationpagEmailInput);
        userPassword = findViewById(R.id.registrationPagePasswordInput);
        submitButton = findViewById(R.id.registerButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticateUser(userName.getText().toString(), userEmail.getText().toString(), userPassword.getText().toString());
            }
        });
    }
}