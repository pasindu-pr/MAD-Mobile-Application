package com.mobileapplicationdevelopment.dogvio.HealthCareMealDB;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mobileapplicationdevelopment.dogvio.R;

import java.util.List;

public class HealthCareAdapter extends ArrayAdapter <HealthCareMealModule> {

    //TextView dmorning, dnoon,dnight,dday;
   // ImageView imageView =
    private  Context context;
    private int  resource;
    List<HealthCareMealModule> healthCareMealModules;


    public HealthCareAdapter(Context context, int resource, List<HealthCareMealModule> healthCareMealModules){
        super(context,resource,healthCareMealModules);
        this.context = context;
        this.resource = resource;
        this.healthCareMealModules = healthCareMealModules;
    }

    //get View method
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);



       TextView dmorning = row.findViewById(R.id.DMorning);
       TextView dnoon = row.findViewById(R.id.DNoon);
       TextView dnight = row.findViewById(R.id.DNight);
       TextView dday = row.findViewById(R.id.DDay);
       //ImageView imageView = row.findViewById(R.id.onMeal);

        //healthCareMealModules[ob1,ob2,ob3,ob4]
        HealthCareMealModule healthCareMealModule = healthCareMealModules.get(position);

        dmorning.setText(healthCareMealModule.getMorningmeal());
        dnoon.setText(healthCareMealModule.getNoonmeal());
        dnight.setText(healthCareMealModule.getNigthmeal());
        dday.setText(healthCareMealModule.getDaymeal());
        //imageView.setVisibility(row.getVisibility());

       //if(healthCareMealModule.getFinished() >0){
         //   imageView.setVisibility(View.VISIBLE);
        //}
        return row;
    }
}
