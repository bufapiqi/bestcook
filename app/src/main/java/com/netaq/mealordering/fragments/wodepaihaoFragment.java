package com.netaq.mealordering.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netaq.mealordering.R;
import com.netaq.mealordering.Reserve;
import com.netaq.mealordering.Waitcode;
import com.netaq.mealordering.adapters.paihaoAdapters;
import com.netaq.mealordering.netWorkCon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class wodepaihaoFragment extends android.support.v4.app.Fragment{

    View view;
    RecyclerView paihao;
    List<Waitcode> list;

    @SuppressLint("ValidFragment")
    public wodepaihaoFragment(List<Waitcode> ll){
        this.list = ll;
    }

    public wodepaihaoFragment(){
        super();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.paihaolist_layout,container,false); //加载personal  layout

        paihao = view.findViewById(R.id.paihao_list_rv);
//        paihao.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        paihao.setLayoutManager(new LinearLayoutManager(getActivity()));

//        Waitcode w = new Waitcode();
//        w.setId(1);
//        w.setName("ss");
//        w.setNum(5);
//        w.setPhone("sdsds");
//        w.setTime("ddsd");
//        w.setUserid(30);
//        w.setWaitcode("275");
//
//        List<Waitcode> temp = new ArrayList<Waitcode>();
//        temp.add(w);

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        Integer a = bundle.getInt("userid");

        List<Waitcode> tt = list;

        paihaoAdapters adapter = new paihaoAdapters(tt);
        paihao.setAdapter(adapter);

        return view;
    }

}
