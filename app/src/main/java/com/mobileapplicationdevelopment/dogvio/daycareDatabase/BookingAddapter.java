package com.mobileapplicationdevelopment.dogvio.daycareDatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mobileapplicationdevelopment.dogvio.R;

import java.util.List;

public class BookingAddapter extends ArrayAdapter<DayCareModule> {

    private Context context;
    private int resourse;
    List<DayCareModule> dayCareModules;

   public BookingAddapter(Context context, int resourse, List<DayCareModule> dayCareModules){
        super(context,resourse,dayCareModules);
        this.context = context;
        this.resourse = resourse;
        this.dayCareModules = dayCareModules;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resourse,parent,false);

        TextView getdogname = row.findViewById(R.id.dogname);
        TextView getbreed = row.findViewById(R.id.dogbreed);
        TextView getage = row.findViewById(R.id.dogage);
        TextView getin = row.findViewById(R.id.dogin);
        TextView getout = row.findViewById(R.id.dogout);
        TextView getpackage = row.findViewById(R.id.dogpack);
        ImageView  imageView = row.findViewById(R.id.onGoing);

        //dayCareModules[];
        DayCareModule dayCareModule =dayCareModules.get(position);
        getdogname.setText(dayCareModule.getBedogname());
        getbreed.setText(dayCareModule.getBedogbreed());
        getage.setText(dayCareModule.getBedogage());
        getin.setText(dayCareModule.getBedogin());
        getout.setText(dayCareModule.getBedogout());
        getpackage.setText(dayCareModule.getBedogpackageno());
        imageView.setVisibility(row.VISIBLE);

        if(dayCareModule.getFinished() > 0){
            imageView.setVisibility(View.VISIBLE);
        }
     return row;



    }
}
