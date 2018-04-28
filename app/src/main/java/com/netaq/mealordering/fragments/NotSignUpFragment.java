package com.netaq.mealordering.fragments;

/**
 * Created by RABOOK on 2018/4/27.
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.netaq.mealordering.R;

public class NotSignUpFragment extends android.support.v4.app.Fragment {

    View view;
    TextView notSignUpText;
    Button SignInButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.plzsignin_layout,container,false); //加载personal  layout

        TextView notSignUp = view.findViewById(R.id.noSignUpText);
        Button signinbutton = view.findViewById(R.id.signInButton);

        return view;

    }

}
