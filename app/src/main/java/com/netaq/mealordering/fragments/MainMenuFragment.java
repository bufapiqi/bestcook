package com.netaq.mealordering.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.netaq.mealordering.R;
import com.netaq.mealordering.activity.MainActivity;

/**
 * Created by Netaq on 10/18/2017.
 */

public class MainMenuFragment extends android.support.v4.app.Fragment {

    View view;
     Button snacksBtn, startersBtn,sandwichesBtn,steaksBtn,beveragesBtn,aboutUsBtn;
     Button MyAccount;
    CallMenuFragmentInterface senderMenuFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            senderMenuFragment = (MainActivity) context;
        } catch (ClassCastException castException) {
            /** The activity does not implement the listener. */
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

       view =inflater.inflate(R.layout.main_menu_layout,container,false);

       snacksBtn =(Button) view.findViewById(R.id.snacks_btn);
        startersBtn =view.findViewById(R.id.starters_btn);
        sandwichesBtn= view.findViewById(R.id.sandwiches_btn);
        steaksBtn =view.findViewById(R.id.steaks_btn);
        beveragesBtn =view.findViewById(R.id.beverages_btn);
        MyAccount = view.findViewById(R.id.MyAccount);


       // snacksBtn.setBackgroundResource(R.mipmap.steak_img);


        snacksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senderMenuFragment.CallMenuFragment(0);

            }
        });
        startersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senderMenuFragment.CallMenuFragment(1);
            }
        });

        sandwichesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senderMenuFragment.CallMenuFragment(2);
            }
        });

        steaksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senderMenuFragment.CallMenuFragment(3);
            }
        });

        beveragesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senderMenuFragment.CallMenuFragment(4);
            }
        });

//        MyAccount.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v){
//                senderMenuFragment.CallMenuFragment(4);
//            }
//
//        }) ;

        //应该是在这里加





        return view;

     }
    public  interface CallMenuFragmentInterface{
        void CallMenuFragment(Integer index);
    }


}
