package com.mobileapplicationdevelopment.dogvio;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mobileapplicationdevelopment.dogvio.data.DAOSocialDog;
import com.mobileapplicationdevelopment.dogvio.data.SocialDog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SocialUserDogListAdapter extends RecyclerView
.Adapter<SocialUserDogListAdapter.SocialUserDogViewHolder>{

    private Context ct;
    private ArrayList<SocialDog> socialUserDogs;
    DAOSocialDog daoSocialDog = new DAOSocialDog();

    public SocialUserDogListAdapter(Context ct, ArrayList<SocialDog> socialUserDogs) {
        this.ct = ct;
        this.socialUserDogs = socialUserDogs;
    }


    public void navigateToEditDetailsPage(int id) {
        Intent intent = new Intent(ct,SocialUserDogUpdate.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("dogId", id);
        ct.startActivity(intent);
    }

    public void deleteDog(int id){
        daoSocialDog.getDatabaseReference().orderByChild("id").equalTo(id)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        for (DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            ds.getRef().removeValue();
                            Toast.makeText(ct, "Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError)
                    {
                        Toast.makeText(ct, "Failed to delete", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @NonNull
    @Override
    public SocialUserDogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ct);
        View view = layoutInflater.inflate(R.layout.social_user_dog_list_item, parent, false);
        return new SocialUserDogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialUserDogViewHolder holder, int position) {
        int adapterPosition = holder.getAdapterPosition();
        Picasso.get().load(socialUserDogs.get(adapterPosition).getImage()).into(holder.socialUserDogImage);
        holder.socialUserDogName.setText(socialUserDogs.get(adapterPosition).getName());
        Picasso.get().load(R.drawable.social_user_delete).into(holder.socialUserDelete);
        Picasso.get().load(R.drawable.social_user_edit).into(holder.socialUserEdit);


        holder.socialUserEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dogid = socialUserDogs.get(holder.getAdapterPosition()).getId();
                navigateToEditDetailsPage(dogid);
            }
        });

        
        holder.socialUserDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ct, "Clicked", Toast.LENGTH_SHORT).show();
                int dogid = socialUserDogs.get(holder.getAdapterPosition()).getId();
                deleteDog(dogid);
            }
        });

    }

    @Override
    public int getItemCount() {
        return socialUserDogs.size();
    }

    public class SocialUserDogViewHolder extends RecyclerView.ViewHolder {

        ImageView socialUserDogImage;
        TextView socialUserDogName;
        ImageView socialUserDelete;
        ImageView socialUserEdit;

        public SocialUserDogViewHolder(@NonNull View itemView) {
            super(itemView);
            socialUserDogImage = itemView.findViewById(R.id.socialUserDogImage);
            socialUserDogName = itemView.findViewById(R.id.socialUserDogName);
            socialUserDelete = itemView.findViewById(R.id.socialUserDelete);
            socialUserEdit = itemView.findViewById(R.id.socialUserEdit);
        }
    }



}
