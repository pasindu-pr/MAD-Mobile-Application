package com.mobileapplicationdevelopment.dogvio.data;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DAOSocialDog {
    private DatabaseReference databaseReference;

    public DAOSocialDog () {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(SocialDog.class.getSimpleName());
    }

    public Task<Void> add (SocialDog socialDog){
        return databaseReference.push().setValue(socialDog);
    }


    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}
