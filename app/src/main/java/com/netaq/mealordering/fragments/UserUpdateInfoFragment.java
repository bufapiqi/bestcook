package com.netaq.mealordering.fragments;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import com.netaq.mealordering.R;

/**
 * Created by RABOOK on 2018/4/27.
 */

public class UserUpdateInfoFragment extends android.support.v4.app.Fragment{

    View view;
    TextView t1,t2,t3;
    EditText e1,e2,e3;
    Button b1,b2,b3,b4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.userupdateinfo_layout,container,false); //加载personal  layout

        t1 = view.findViewById(R.id.usernamelabel);
        t2 = view.findViewById(R.id.shouhuolabel);
        t3 = view.findViewById(R.id.mimalabel);

        //这里获得user信息
        //这里获得user信息

        e1 = view.findViewById(R.id.updateEdit);
        e2 = view.findViewById(R.id.updateshouhuoEdit);
        e3 = view.findViewById(R.id.updatemimaEdit);

        String shouhuo = e2.getText().toString();
        String mima = e3.getText().toString();


        b1 = view.findViewById(R.id.updateusernameButton);
        b2 = view.findViewById(R.id.shouhuobutton);
        b3 = view.findViewById(R.id.mimaButton);
        b4 = view.findViewById(R.id.tuichudenglu);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不能修改
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里写上修改的代码
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里写上修改的代码
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里退出登录
            }
        });



        return view;
    }
}
