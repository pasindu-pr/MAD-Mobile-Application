package com.mobileapplicationdevelopment.dogvio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HealthCare_ToMealAdapter extends ArrayAdapter<HealthCare_ToMeal> {

    private Context context;
    private int resource;
    List<HealthCare_ToMeal> todos;

    HealthCare_ToMealAdapter(Context context, int resource, List<HealthCare_ToMeal> todos){
        super(context,resource,todos);
        this.context = context;
        this.resource = resource;
        this.todos = todos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView morning = row.findViewById(R.id.EditToMealTopic);
        TextView noon = row.findViewById(R.id.noon);
        TextView night = row.findViewById(R.id.night);
        TextView day = row.findViewById(R.id.day);

        ImageView imageView = row.findViewById(R.id.onGoing);


        // todos [obj1,obj2,obj3]
        HealthCare_ToMeal healthCareToMeal = todos.get(position);
        morning.setText(healthCareToMeal.getMorning());
        noon.setText(healthCareToMeal.getNoon());
        night.setText(healthCareToMeal.getNight());
        day.setText(healthCareToMeal.getDay());
        imageView.setVisibility(row.INVISIBLE);

        if(healthCareToMeal.getFinished() > 0){
            imageView.setVisibility(View.VISIBLE);
        }
        return row;
    }
}
