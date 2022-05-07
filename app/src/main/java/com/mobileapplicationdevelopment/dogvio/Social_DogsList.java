package com.mobileapplicationdevelopment.dogvio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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


        recyclerView = findViewById(R.id.socialDogListRecycleView);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        daoSocialDog.getDatabaseReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    for(DataSnapshot child: snapshot.getChildren()){
                        SocialDog socialDog = child.getValue(SocialDog.class);
                        socialDogs.add(socialDog);
                    }

                    SocialDogListAdapter socialDogListAdapter = new SocialDogListAdapter(getApplicationContext(), socialDogs);
                    recyclerView.setAdapter(socialDogListAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Database error", error.getMessage());
            }
        });
    }
}