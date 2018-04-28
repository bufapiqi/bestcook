package com.netaq.mealordering.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import com.netaq.mealordering.R;

/**
 * Created by RABOOK on 2018/4/26.
 */

public class PersonalFragment extends android.support.v4.app.Fragment{

    View view;
    ImageView userPhoto;
    TextView userName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.personal_layout,container,false); //加载personal  layout

        userPhoto = (ImageView) view.findViewById(R.id.user_photo);
        userName = (TextView) view.findViewById(R.id.username);

        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment UserUpdate = new UserUpdateInfoFragment();
                FragmentTransaction nft = getChildFragmentManager().beginTransaction();
//                nft.add(R.id.bottom_info,UserUpdate).commit();
                nft.replace(R.id.bottom_info,UserUpdate).commit();
            }
        });

        //这里获得user的信息
        //这里获得user的信息

        if(true){ //已经登录了
            Fragment userBookingFragment = new UserBookingFragment();
            FragmentTransaction nft = getChildFragmentManager().beginTransaction();
            nft.add(R.id.bottom_info,userBookingFragment).commit();
        }else{ //没有登录
            Fragment notsignin = new NotSignUpFragment();
            FragmentTransaction nft = getChildFragmentManager().beginTransaction();
            nft.add(R.id.bottom_info,notsignin).commit();
        }


        return view;

    }

}
