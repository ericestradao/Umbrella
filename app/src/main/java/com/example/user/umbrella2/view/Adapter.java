package com.example.user.umbrella2.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.umbrella2.R;
import com.example.user.umbrella2.model.ForecastPojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    ForecastPojo forecast;
    Context context;

    final String TAG = Adapter.class.getSimpleName();

    public Adapter(ForecastPojo weather, Context context){
        this.forecast = weather;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv_temp.setText(forecast.getList().get(i).getMain().getTemp().toString());
        viewHolder.tv_hour.setText(forecast.getList().get(i).getDtTxt());
    }

    @Override
    public int getItemCount() {
        Date currentTime = Calendar.getInstance().getTime();

        System.out.println("Current time => " + currentTime);
        SimpleDateFormat df = new SimpleDateFormat("HHmm");
        String formattedDate = df.format(currentTime);
        Log.d(TAG, "Hora: "+formattedDate);

        return forecast.getList().size();
    }
}
