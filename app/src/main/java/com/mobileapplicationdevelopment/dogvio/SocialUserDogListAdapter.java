package com.mobileapplicationdevelopment.dogvio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobileapplicationdevelopment.dogvio.data.SocialDog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SocialUserDogListAdapter extends RecyclerView
.Adapter<SocialUserDogListAdapter.SocialUserDogViewHolder>{

    private Context ct;
    private ArrayList<SocialDog> socialUserDogs;

    public SocialUserDogListAdapter(Context ct, ArrayList<SocialDog> socialUserDogs) {
        this.ct = ct;
        this.socialUserDogs = socialUserDogs;
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
