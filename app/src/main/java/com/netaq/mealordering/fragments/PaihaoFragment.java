package com.netaq.mealordering.fragments;

/**
 * Created by RABOOK on 2018/4/27.
 */

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import com.netaq.mealordering.R;
import com.netaq.mealordering.netWorkCon;

import java.io.IOException;

public class PaihaoFragment extends android.support.v4.app.Fragment{

    View view;
    TextView yongcnalabel,datelabel,paihaophonelabel;
    EditText yongcanEdit,paihaophone;
    TimePicker tppick;
    Button yudingBt;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.paihao_layout,container,false); //加载personal  layout

        yongcnalabel = view.findViewById(R.id.yongcanlabel);

        yongcanEdit = view.findViewById(R.id.yongcanEditText);

        paihaophonelabel = view.findViewById(R.id.yongcanphone);

        paihaophone = view.findViewById(R.id.paihaophoneEditText);

        datelabel = view.findViewById(R.id.datelabel);

        tppick = view.findViewById(R.id.tpPicker);
        tppick.setIs24HourView(true);

        yudingBt = view.findViewById(R.id.yudingbutton);



        yudingBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                int hour = v.get
                //这里排号的url
                String yudingrenshu = yongcanEdit.getText().toString(); //预订的人数
                String paihaopo = paihaophone.getText().toString();
                int h = tppick.getHour();
                int m = tppick.getMinute();
                String time = "午市";

                if(h>=18){
                    time = "晚市";
                }

                Intent intent = getActivity().getIntent();
                Bundle bundle = intent.getExtras();

                int userid = bundle.getInt("userid");
                String name = bundle.getString("username");

                paihaoTask paihao = new paihaoTask();
                paihao.execute(time,yudingrenshu,name,paihaopo,String.valueOf(userid));
            }
        });

        return view;
    }

    private class paihaoTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {

            netWorkCon net = new netWorkCon(getActivity());

            String res = "";

            try{
                res = net.getCode(strings[0],Integer.parseInt(strings[1]),strings[2],strings[3], Integer.parseInt(strings[4]));
            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }

            return res;
        }

        @Override
        protected void onPostExecute(String sss) {

            Toast.makeText(getActivity(),"您的取号为： "+sss,Toast.LENGTH_SHORT).show();

            Intent i = getActivity().getIntent();
            startActivity(i);

//            wodereserveFragment re = new wodereserveFragment(reserves);
//            FragmentTransaction ft = person.getChildFragmentManager().beginTransaction();
//            ft.replace(R.id.bottom_info,re).commit();

        }
    }

}
