package com.netaq.mealordering.fragments;

/**
 * Created by RABOOK on 2018/4/27.
 */

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;

import com.netaq.mealordering.OutFoodVO;
import com.netaq.mealordering.R;
import com.netaq.mealordering.Reserve;
import com.netaq.mealordering.Waitcode;
import com.netaq.mealordering.netWorkCon;

import java.io.IOException;
import java.util.List;

public class UserBookingFragment extends android.support.v4.app.Fragment{


    View view;
    PersonalFragment person;

//    private ArrayAdapter<String> arr_aAdapter;
    // 新建一个数据适配器

    @SuppressLint("ValidFragment")
    public UserBookingFragment(PersonalFragment per){
        this.person = per;
    }

    public UserBookingFragment(){
    }

    Button o1,o2,o3;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
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

        o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getIntent();
                Bundle bundle = intent.getExtras();
                int a = bundle.getInt("userid");

                getReserveTask get = new getReserveTask();
                get.execute(a);

            }
        });

        o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("有没有执行到这里","sdsadsad");

                Intent intent = getActivity().getIntent();
                Bundle bundle = intent.getExtras();
                int a = bundle.getInt("userid");

                getPaihaoTask get = new getPaihaoTask();
                get.execute(a);

            }
        });

        o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getIntent();
                Bundle bundle = intent.getExtras();
                int a = bundle.getInt("userid");

                getOutFoodTask get = new getOutFoodTask();
                get.execute(a);

            }
        });


        return view;

    }


    private class getOutFoodTask extends AsyncTask<Integer,Void,List<OutFoodVO>>{

        @Override
        protected List<OutFoodVO> doInBackground(Integer... integers) {

            netWorkCon net = new netWorkCon(getActivity());

            List<OutFoodVO> outfoods = null;

            try{
                outfoods = net.checkOutfood(integers[0]);
            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }


            return outfoods;
        }

        @Override
        protected void onPostExecute(List<OutFoodVO> outFoodVOS) {
//            super.onPostExecute(outFoodVOS);

            if(outFoodVOS==null){
                return ;
            }

            wodeoutfoodFragment outf = new wodeoutfoodFragment(outFoodVOS);
            FragmentTransaction ft = person.getChildFragmentManager().beginTransaction();
            ft.replace(R.id.bottom_info,outf).commit();
        }
    }


    private class getReserveTask extends AsyncTask<Integer,Void,List<Reserve>>{

        @Override
        protected List<Reserve> doInBackground(Integer... integers) {

            netWorkCon net = new netWorkCon(getActivity());

            List<Reserve> reserves = null;

            try{
                reserves = net.checkReserve(integers[0]);
            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }

            return reserves;
        }

        @Override
        protected void onPostExecute(List<Reserve> reserves) {

            if(reserves==null){
                return ;
            }

            wodereserveFragment re = new wodereserveFragment(reserves);
            FragmentTransaction ft = person.getChildFragmentManager().beginTransaction();
            ft.replace(R.id.bottom_info,re).commit();

        }
    }


    private class getPaihaoTask extends AsyncTask<Integer,Void,List<Waitcode>> {

        @Override
        protected List<Waitcode> doInBackground(Integer... integers) {

            netWorkCon net = new netWorkCon(getActivity());

            List<Waitcode> waitcodes = null;

            try{
                waitcodes = net.checkCode(integers[0]);
            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }

            return waitcodes;
        }

        @Override
        protected void onPostExecute(List<Waitcode> waitcodes) {
            if(waitcodes==null){
                return ;
            }

            Log.i("到底有没有WAITCODE",""+waitcodes.size());

            wodepaihaoFragment ff = new wodepaihaoFragment(waitcodes);
            FragmentTransaction ft = person.getChildFragmentManager().beginTransaction();
            ft.replace(R.id.bottom_info,ff).commit();

        }
    }


}
