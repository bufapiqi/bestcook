package com.netaq.mealordering.fragments;

/**
 * Created by RABOOK on 2018/4/27.
 */

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TimePicker;

import com.netaq.mealordering.R;

public class PaihaoFragment extends android.support.v4.app.Fragment{

    View view;
    TextView yongcnalabel,datelabel;
    EditText yongcanEdit;
    TimePicker tppick;
    Button yudingBt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.paihao_layout,container,false); //加载personal  layout

        yongcnalabel = view.findViewById(R.id.yongcanlabel);

        yongcanEdit = view.findViewById(R.id.yongcanEditText);

        datelabel = view.findViewById(R.id.datelabel);

        tppick = view.findViewById(R.id.tpPicker);

        yudingBt = view.findViewById(R.id.yudingbutton);

        String yudingrenshu = yongcanEdit.getText().toString(); //预订的人数

        int hour = tppick.getHour();
        int min = tppick.getMinute();

        yudingBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                int hour = v.get
            }
        });

        return view;
    }
}
