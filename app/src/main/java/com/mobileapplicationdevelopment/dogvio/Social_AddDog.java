package com.mobileapplicationdevelopment.dogvio;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobileapplicationdevelopment.dogvio.data.DAOSocialDog;
import com.mobileapplicationdevelopment.dogvio.data.SocialDog;

import java.time.LocalDate;
import java.time.Period;


public class Social_AddDog extends AppCompatActivity {

    //    Inputs
    EditText dogDateOfBirth;
    EditText dogName;
    EditText dogBreed;
    EditText sex;
    EditText contactNumber;
    EditText imageLink;
    EditText description;
    Double latitude;
    Double longtitude;
    EditText dogColour;

    //    Button
    AppCompatButton addDogSubmitButton;

    //    Get Location Access from GPS
    LocationManager locationManager;
    LocationListener locationListener;
    private FirebaseAuth mAuth;


    private void addDogToTheApplication() {

        String dogName = this.dogName.getText().toString();
        String breed = this.dogBreed.getText().toString();
        String dob = this.dogDateOfBirth.getText().toString();
        String sex = this.sex.getText().toString();
        String contactNumber = this.contactNumber.getText().toString();
        String image = this.imageLink.getText().toString();
        String description = this.description.getText().toString();
        int age = 0;
//        Dog's age calculation - Calculation 1
        String[] dateOfBirthSplitArray = dob.split("/");
        String dogColour = this.dogColour.getText().toString();

     try {
         age = Period.between(
                 LocalDate.of(Integer.parseInt(dateOfBirthSplitArray[0]), Integer.parseInt(dateOfBirthSplitArray[1]),
                         Integer.parseInt(dateOfBirthSplitArray[2])),
                 LocalDate.now()
         ).getYears();


     } catch (Exception e){
         Log.e("ExceptionTag", e.getMessage(), e);
     }

        int randomNum = (int)(Math.random() * 5000000);
        FirebaseUser currentUser = mAuth.getCurrentUser();

        SocialDog socialDog = new SocialDog(dogName, breed, sex, age, contactNumber,
                image, description, longtitude, latitude, randomNum, dogColour, currentUser.getUid());

        //    Firebase Data Reference
        DAOSocialDog firebaseDog = new DAOSocialDog();
        firebaseDog.add(socialDog).addOnSuccessListener(res -> {
            showSuccessAlert();
        }).addOnFailureListener(failure -> {
            Log.e("Data Insertion Error", failure.getMessage());
        });
    }

    private void showSuccessAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(Social_AddDog.this, R.style.SocialDogAlertTheme).create();
        alertDialog.setTitle("Your dog has been added successfully");
        alertDialog.setMessage("Your dog on board! Visitors will see your dog " +
                "and the interested ones wil contact you!");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialog.show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_social_add_dog);
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        dogDateOfBirth = findViewById(R.id.dogDobInput);
        dogName = findViewById(R.id.dogNameInput);
        dogBreed = findViewById(R.id.dogBreedInput);
        sex = findViewById(R.id.dogSexInput);
        contactNumber = findViewById(R.id.dogContactInput);
        imageLink = findViewById(R.id.imageLinkInput);
        description = findViewById(R.id.dogDescriptionInput);
        addDogSubmitButton = findViewById(R.id.addDogSubmitButton);
        dogColour = findViewById(R.id.dogColourInput);


        addDogSubmitButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                addDogToTheApplication();
            }
        });


//       Location Utilities

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                latitude = location.getLatitude();
                longtitude = location.getLongitude();
                Log.i("This is your location", location.toString());
            }
        };



//        Location checking and asking from user
        ActivityResultLauncher<String[]> locationPermissionRequest =
                registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions()
                        , result -> {

                            Boolean fineLocationGranted = null;

                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                                fineLocationGranted = result.getOrDefault(
                                        Manifest.permission.ACCESS_FINE_LOCATION, false);
                            }

                            Boolean coarseLocationGranted = null;

                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                                coarseLocationGranted = result.getOrDefault(
                                        Manifest.permission.ACCESS_COARSE_LOCATION, false);
                            }


                            if (!fineLocationGranted || !coarseLocationGranted) {
                                AlertDialog alertDialog = new AlertDialog.Builder(Social_AddDog.this,
                                        R.style.SocialDogAlertTheme).create();
                                alertDialog.setTitle("Location Access Denied");
                                alertDialog.setMessage("Your dog on board! Visitors will see your dog " +
                                        "and the interested ones wil contact you!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Okay",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });

                                alertDialog.show();
                            } else {
                                if (ActivityCompat.checkSelfPermission(this,
                                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                    return;
                                }
                                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                        0, 0, locationListener);
                            }
                        }
                );


        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    0, 0, locationListener);

        } else {
            // You can directly ask for the permission.
            locationPermissionRequest.launch(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            });
    }
}}