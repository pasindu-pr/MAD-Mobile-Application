package com.mobileapplicationdevelopment.dogvio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mobileapplicationdevelopment.dogvio.data.DAOSocialDog;
import com.mobileapplicationdevelopment.dogvio.data.SocialDog;

import java.util.ArrayList;

public class social_user_doglist extends AppCompatActivity {

    AppCompatButton addSocialDogButton;
    RecyclerView recyclerView;
    ArrayList<SocialDog> socialuserDogs = new ArrayList<SocialDog>();
    private FirebaseAuth mAuth;

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
        DAOSocialDog daoSocialDog = new DAOSocialDog();
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        addSocialDogButton = findViewById(R.id.socialUserDogListAddDogButton);
        recyclerView = findViewById(R.id.userUserDogListRecyclerView);
        SocialUserDogListAdapter socialUserDogListAdapter = new SocialUserDogListAdapter(getApplicationContext(), socialuserDogs);
        recyclerView.setAdapter(socialUserDogListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

       if(user.getUid() != null){
           daoSocialDog.getDatabaseReference().orderByChild("userID").equalTo(user.getUid()).addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot snapshot) {
                   if(snapshot.exists()){

                       for(DataSnapshot child: snapshot.getChildren()){
                           SocialDog socialDog = child.getValue(SocialDog.class);
                           socialuserDogs.add(socialDog);
                       }

                       socialUserDogListAdapter.notifyDataSetChanged();
                   }
               }

               @Override
               public void onCancelled(@NonNull DatabaseError error) {
                   Log.e("Database error", error.getMessage());
               }
           });
       }else  {
           Intent intent = new Intent(this, LoginPage.class);
           startActivity(intent);
       }


        addSocialDogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSocialDogButtonClick();
            }
        });
    }
}