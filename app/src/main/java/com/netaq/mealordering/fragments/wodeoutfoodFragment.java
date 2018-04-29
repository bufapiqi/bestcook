package com.netaq.mealordering.fragments;

/**
 * Created by RABOOK on 2018/4/29.
 */

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.netaq.mealordering.OutFoodVO;
import com.netaq.mealordering.R;
import com.netaq.mealordering.RecycleViewDivider;
import com.netaq.mealordering.adapters.outfoodAdapters;
import java.util.List;

public class wodeoutfoodFragment extends android.support.v4.app.Fragment {

    View view;
    RecyclerView outfood;
    List<OutFoodVO> list;

    public wodeoutfoodFragment(){
        super();
    }

    @SuppressLint("ValidFragment")
    public wodeoutfoodFragment(List<OutFoodVO> list){
        this.list = list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.outfoodlist_layout,container,false); //加载personal  layout

        outfood = view.findViewById(R.id.outfood_list_rv);
        outfood.setLayoutManager(new LinearLayoutManager(getActivity()));
        outfood.addItemDecoration(new RecycleViewDivider(
                getContext(), LinearLayoutManager.HORIZONTAL, 15, getResources().getColor(R.color.colorPrimary)
        ));
//        RecycleViewDivider myfenge = new RecycleViewDivider(getContext(), LinearLayout.HORIZONTAL);

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        Integer a = bundle.getInt("userid");

        List<OutFoodVO> tt = list;

        outfoodAdapters aa = new outfoodAdapters(tt);
        outfood.setAdapter(aa);

        return view;
    }


}
