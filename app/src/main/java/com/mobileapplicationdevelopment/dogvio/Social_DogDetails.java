package com.mobileapplicationdevelopment.dogvio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mobileapplicationdevelopment.dogvio.data.DAOSocialDog;
import com.mobileapplicationdevelopment.dogvio.data.SocialDog;
import com.squareup.picasso.Picasso;

public class Social_DogDetails extends AppCompatActivity {

    private DAOSocialDog daoSocialDog = new DAOSocialDog();

    ImageView coverPhoto;
    TextView dogName;
    TextView dogBreed;
    TextView age;
    TextView gender;
    TextView colour;
    TextView description;
    AppCompatButton callToActionButton;
    String telephoneNumber;
    ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_social_dog_details);

//        UI elements
        coverPhoto = findViewById(R.id.socialDogDetailsCoverImage);
        dogName = findViewById(R.id.socialDogDetailsDogName);
        dogBreed = findViewById(R.id.socialDogDetailsBreed);
        age = findViewById(R.id.socialDogDetailsDogAge);
        gender = findViewById(R.id.socialDogDetailsGender);
        colour = findViewById(R.id.socialDogDetailsColor);
        description = findViewById(R.id.socialDogDetailsDescription);
        callToActionButton = findViewById(R.id.socialDogDetailsCallOwnerButton);
        backbutton = findViewById(R.id.socialDogDetailsBackButton);

        Intent intent = getIntent();
        int dogid =  intent.getIntExtra("dogId", 0);
        Log.i("id of dog", Integer.toString(dogid));

        daoSocialDog.getDatabaseReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    for(DataSnapshot child: snapshot.getChildren()){
                        SocialDog socialDog = child.getValue(SocialDog.class);

                        if(socialDog.getId() == dogid){
                            Picasso.get().load(socialDog.getImage()).into(coverPhoto);
                            dogName.setText(socialDog.getName());
                            dogBreed.setText(socialDog.getBreed());
                            age.setText(Integer.toString(socialDog.getAge()));
                            gender.setText(socialDog.getSex());
                            colour.setText(socialDog.getColor());
                            description.setText(socialDog.getDescription());
                            telephoneNumber = socialDog.getContactNumber();
                        }

                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Database error", error.getMessage());
            }
        });


        callToActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+telephoneNumber));
                startActivity(intent);
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), Social_DogsList.class);
                startActivity(intent1);
            }
        });
    }
}