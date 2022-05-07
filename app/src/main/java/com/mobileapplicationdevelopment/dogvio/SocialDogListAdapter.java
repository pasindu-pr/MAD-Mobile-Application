package com.mobileapplicationdevelopment.dogvio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ValueEventListener;
import com.mobileapplicationdevelopment.dogvio.data.SocialDog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SocialDogListAdapter extends RecyclerView.Adapter<SocialDogListAdapter.SocialViewHolder>{

    Context ct;
    ArrayList<SocialDog> socialDogs;

    public SocialDogListAdapter(Context ct, ArrayList<SocialDog> socialDogs) {
        this.ct = ct;
        this.socialDogs = socialDogs;
    }


    public SocialDogListAdapter.SocialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater  = LayoutInflater.from(ct);
        View view = layoutInflater.inflate(R.layout.social_dog_list_item, parent, false);
        return new SocialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialDogListAdapter.SocialViewHolder holder, int position) {
        Picasso.get().load(socialDogs.get(position).getImage()).into(holder.imageView);
        holder.textView1.setText(socialDogs.get(position).getName());
        holder.dogDescription.setText(socialDogs.get(position).getBreed());
    }

    @Override
    public int getItemCount() {
        return socialDogs.size();
    }

    public class SocialViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView1;
        TextView dogDescription;

        public SocialViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.socialListItemDogImage);
            textView1 = itemView.findViewById(R.id.socialListItemDogName);
            dogDescription = itemView.findViewById(R.id.socialDogListItemBreed);
        }
    }
}
