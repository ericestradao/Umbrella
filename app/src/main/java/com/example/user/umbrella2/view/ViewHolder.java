package com.example.user.umbrella2.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.umbrella2.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView tv_temp;
    TextView tv_hour;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_temp = itemView.findViewById(R.id.tv_temp);
        tv_hour = itemView.findViewById(R.id.tv_hour);

    }
}
