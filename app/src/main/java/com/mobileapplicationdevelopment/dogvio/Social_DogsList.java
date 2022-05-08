package com.mobileapplicationdevelopment.dogvio;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mobileapplicationdevelopment.dogvio.data.DAOSocialDog;
import com.mobileapplicationdevelopment.dogvio.data.SocialDog;

import java.util.ArrayList;
import java.util.Arrays;

public class Social_DogsList extends AppCompatActivity {

    CardView dogListCart;
    RecyclerView recyclerView;
    DAOSocialDog daoSocialDog = new DAOSocialDog();
    ArrayList<SocialDog> socialDogs = new ArrayList<SocialDog>();


//    GPS variables
    Double latitude = 0.0;
    Double longtitude = 0.0;
    Location currentUserLocation = new Location("CurrentUserLocation");

    LocationManager locationManager;
    LocationListener locationListener;


//    Request location updates
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull @org.jetbrains.annotations.NotNull String[] permissions,
                                           @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                        0, locationListener);
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_social_dogs_list);

//        Recycler View
        recyclerView = findViewById(R.id.socialDogListRecycleView);
        SocialDogListAdapter socialDogListAdapter = new SocialDogListAdapter(getApplicationContext(), socialDogs);
        recyclerView.setAdapter(socialDogListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



        //       Location Utilities
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                latitude = location.getLatitude();
                longtitude = location.getLongitude();

//                Create the current user location

                currentUserLocation.setLatitude(latitude);
                currentUserLocation.setLongitude(longtitude);


                for(SocialDog socialDog: socialDogs){
                    // Get current dog location and check the distance
                    Location currentDogLocation = new Location("currentDogLocation");
                    currentDogLocation.setLatitude(socialDog.getLatitude());
                    currentDogLocation.setLongitude(socialDog.getLongtitude());

                    // Check distance : return double -> m
                    // If distance is less than 5 km we display that dog
                    double distanceFromUserToDog = currentUserLocation.distanceTo(currentDogLocation);
                    Log.i("Distance", Double.toString(distanceFromUserToDog / 1000));
                    if(((distanceFromUserToDog / 1000) > 5)){
                        socialDogs.remove(socialDog);
                    }
                }

//                Notify the adapter after sorting dogs according to the location
//                So the adapter will get notified and display the dogs
                socialDogListAdapter.notifyDataSetChanged();

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
                                AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext(),
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
                                        Manifest.permission.ACCESS_FINE_LOCATION) !=
                                        PackageManager.PERMISSION_GRANTED &&
                                        ActivityCompat.checkSelfPermission(this,
                                                Manifest.permission.ACCESS_COARSE_LOCATION)
                                                != PackageManager.PERMISSION_GRANTED) {
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


//        Read Values from database
        daoSocialDog.getDatabaseReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
//Add the dogs to the social dogs array list but don't notify the adapter
                    for(DataSnapshot child: snapshot.getChildren()){
                        SocialDog socialDog = child.getValue(SocialDog.class);
                            socialDogs.add(socialDog);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Database error", error.getMessage());
            }
        });

    }
}