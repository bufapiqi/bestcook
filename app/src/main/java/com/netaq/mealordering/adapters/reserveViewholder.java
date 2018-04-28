package com.netaq.mealordering.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.netaq.mealordering.R;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class reserveViewholder extends RecyclerView.ViewHolder{

    TextView reserveNameLabel,reserveName,
            reserveNumLabel,reserveNum,
            reservePhoneLabel,reservePhone,
            reserveTimeLabel,reserveTime,
            reserveDesLabel,reserveDes;


    public reserveViewholder(View itemView) {
        super(itemView);

        reserveNameLabel = itemView.findViewById(R.id.reserveNameLabel);
        reserveName = itemView.findViewById(R.id.reserveName);
        reserveNumLabel = itemView.findViewById(R.id.reserveNumLabel);
//        reserveNum = itemView.findViewById(R.id.reserveNum);
        reservePhoneLabel = itemView.findViewById(R.id.reservephoneLabel);
        reservePhone = itemView.findViewById(R.id.reservePhone);
        reserveTimeLabel = itemView.findViewById(R.id.reserveTimeLabel);
        reserveTime = itemView.findViewById(R.id.reserveTime);
        reserveDesLabel = itemView.findViewById(R.id.reserveDesLabel);
        reserveDes = itemView.findViewById(R.id.reserveDes);

    }
}
