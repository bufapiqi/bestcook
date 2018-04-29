package com.netaq.mealordering.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netaq.mealordering.R;
import com.netaq.mealordering.RecycleViewDivider;
import com.netaq.mealordering.Reserve;
import com.netaq.mealordering.adapters.paihaoAdapters;
import com.netaq.mealordering.adapters.reserveAdapters;
import com.netaq.mealordering.netWorkCon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class wodereserveFragment extends android.support.v4.app.Fragment {

    View view;
    RecyclerView reserve;

    List<Reserve> list;

    public wodereserveFragment(){
        super();
    }

    @SuppressLint("ValidFragment")
    public wodereserveFragment(List<Reserve> ll){
        this.list = ll;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.reservelist_layout,container,false); //加载personal  layout

        reserve = view.findViewById(R.id.reserve_list_rv);
        reserve.setLayoutManager(new LinearLayoutManager(getActivity()));
        reserve.addItemDecoration(new RecycleViewDivider(
                getContext(), LinearLayoutManager.HORIZONTAL, 15, getResources().getColor(R.color.colorPrimary)
        ));

//        List<Reserve> temp = new ArrayList<Reserve>();
//        Reserve r = new Reserve();
//        r.setDescription("sdadsa");
//        r.setId(1);
//        r.setName("sdasd");
//        r.setNum(3);
//        r.setPhone("sdadsa");
//        r.setTime("dsadsa");
//        r.setUserid(6);
//        temp.add(r);

//        Intent intent = new Intent();
//        Bundle bundle = intent.getExtras();
//        Integer a = bundle.getInt("userid");

        List<Reserve> tt = list;

        reserveAdapters adapter = new reserveAdapters(tt);
        reserve.setAdapter(adapter);

        return view;
    }


}
