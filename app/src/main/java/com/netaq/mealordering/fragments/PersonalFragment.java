package com.netaq.mealordering.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


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

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        boolean isLogin = false;
        if(bundle != null && bundle.containsKey("username")){
            isLogin = true;
        }
        if(isLogin){ //已经登录了

            userName.setText(bundle.getString("username"));

            try {
                Bitmap bitmap = getBitmap(bundle.getString("photoLink"));
                userPhoto.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


            Fragment userBookingFragment = new UserBookingFragment(this);
            FragmentTransaction nft = getChildFragmentManager().beginTransaction();
            nft.add(R.id.bottom_info,userBookingFragment).commit();
        }else{ //没有登录
            Fragment notsignin = new NotSignUpFragment();
            FragmentTransaction nft = getChildFragmentManager().beginTransaction();
            nft.add(R.id.bottom_info,notsignin).commit();
        }


        return view;

    }

    public Bitmap getBitmap(String path) throws IOException {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
