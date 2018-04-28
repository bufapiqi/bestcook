package com.netaq.mealordering.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.netaq.mealordering.R;
import com.netaq.mealordering.Reserve;
import com.netaq.mealordering.netWorkCon;

import java.io.IOException;
import java.util.List;

/**
 * Created by RABOOK on 2018/4/29.
 */

public class OrderMealFragment extends android.support.v4.app.Fragment{

    View view;
    TextView dingcanlabel,spcialLabel,phonelabel;
    EditText dingcanEdit,special,phoneEdit;
    DatePicker dingcanpicker;
    TimePicker tppick;
    Button dingcanBt;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.ordermeal_layout,container,false); //加载personal  layout

        dingcanlabel = view.findViewById(R.id.dingcanlabel);
        dingcanEdit = view.findViewById(R.id.dingcanEditText);
        dingcanpicker = view.findViewById(R.id.mealdatepick);
        tppick = view.findViewById(R.id.mealtpPicker);
        dingcanBt = view.findViewById(R.id.dingcanbutton);
        spcialLabel = view.findViewById(R.id.speciallabel);
        special = view.findViewById(R.id.specialEditText);
        phonelabel = view.findViewById(R.id.phonelabel);
        phoneEdit = view.findViewById(R.id.phoneEditText);

        String dingcanrenshu = dingcanEdit.getText().toString(); //预订的人数

        dingcanBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String dingcanrenshu = dingcanEdit.getText().toString();

                int year = dingcanpicker.getYear();
                int month = dingcanpicker.getMonth();
                int day = dingcanpicker.getDayOfMonth();

                int h = tppick.getHour();
                int m = tppick.getMinute();

                Intent intent = getActivity().getIntent();
                Bundle bundle = intent.getExtras();

                String name = bundle.getString("username");
                int userid = bundle.getInt("userid");
                int mans = Integer.parseInt(dingcanrenshu);
                String date = year+"/"+month+"/"+day+" "+h+":"+m+":"+"00";
                final String speciall = special.getText().toString();
                final String phone = phoneEdit.getText().toString();

                //这里异步任务
                ReserveTask res = new ReserveTask();
                res.execute(date,String.valueOf(mans),name,phone,speciall,String.valueOf(userid));

            }
        });

        return view;
    }

    private class ReserveTask extends AsyncTask<String,Void,Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {

            netWorkCon net = new netWorkCon(getActivity());

            Boolean isReserve = false;

            try{
                isReserve = net.reserve(strings[0],Integer.parseInt(strings[1]),strings[2],strings[3],
                        strings[4],Integer.parseInt(strings[5]));
            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }

            return isReserve;
        }

        @Override
        protected void onPostExecute(Boolean bool) {

            if (bool){
                Toast.makeText(getActivity(),"订餐失败！",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getActivity(),"订餐成功！",Toast.LENGTH_SHORT).show();
            }  //这里可能需要改一下

//            wodereserveFragment re = new wodereserveFragment(reserves);
//            FragmentTransaction ft = person.getChildFragmentManager().beginTransaction();
//            ft.replace(R.id.bottom_info,re).commit();

        }
    }

}
