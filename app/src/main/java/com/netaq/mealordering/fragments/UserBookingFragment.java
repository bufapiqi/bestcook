package com.netaq.mealordering.fragments;

/**
 * Created by RABOOK on 2018/4/27.
 */

import android.support.annotation.Nullable;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;

import com.netaq.mealordering.R;

public class UserBookingFragment extends android.support.v4.app.Fragment{


    View view;

//    private ArrayAdapter<String> arr_aAdapter;
    // 新建一个数据适配器

    Button o1,o2,o3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.userbooking_info,container,false); //加载personal  layout

        o1 = view.findViewById(R.id.orderingInfo);
        o2 = view.findViewById(R.id.SeatInfo);
        o3 = view.findViewById(R.id.waimaiInfo);

//        list = view.findViewById(R.id.booking_list);
//
//        String[] arr_data = {"订餐信息", "预订信息", "排号信息"};// 创建的数据源
//
//        arr_aAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr_data);


        return view;

    }

}
