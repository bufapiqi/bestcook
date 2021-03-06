package com.netaq.mealordering.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.netaq.mealordering.OutFoodVO;
import com.netaq.mealordering.R;
import com.netaq.mealordering.classes.MenuItems;
import com.netaq.mealordering.netWorkCon;
import com.netaq.mealordering.orderVO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by Netaq on 10/22/2017.
 */

public class CheckoutFragment extends Fragment {


    TextView subTotal, deliveryTotal, totalCharge,toolbarTtile;
    Button zhifubt;

    TextView dizhilabel,peisonglabel,beizhulabel,checkphonelabel;
    EditText dizhi,peisong,beizhu,checkphone;

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.checkout_layout,container,false);
        subTotal = view.findViewById(R.id.sub_total_price);
        deliveryTotal = view.findViewById(R.id.delivery_tax);
        totalCharge = view.findViewById(R.id.total_charge);
        zhifubt = view.findViewById(R.id.zhifubutton);

        dizhilabel = view.findViewById(R.id.peisonglabel);
        peisonglabel = view.findViewById(R.id.reachTimeLabel);
        beizhulabel = view.findViewById(R.id.beizhilabel);
        checkphonelabel = view.findViewById(R.id.checkphonelabel);

        Log.i("有没有到这里怕","点击到这里了没有");

        dizhi = view.findViewById(R.id.peisongEdit);
        peisong = view.findViewById(R.id.reachTimeEdit);
        beizhu = view.findViewById(R.id.beizhuEdit);
        checkphone = view.findViewById(R.id.checkoutphoneEdit);

        subTotal.setText("0 Dhs.");
        totalCharge.setText("0 Dhs.");
        deliveryTotal.setText("0 Dhs.");

        zhifubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里填写支付的URL

                Log.i("支付有没有","点击到这里了没有");

                Intent intent = getActivity().getIntent();
                Bundle bundle = intent.getExtras();
                int total = Integer.parseInt(bundle.getString("subPrice"))+50; //总支出
                ArrayList<MenuItems> items = (ArrayList<MenuItems>) bundle.getSerializable("orderlist");

                List<orderVO> resItems = new ArrayList<orderVO>();

                for(MenuItems item:items){
                    orderVO temp = new orderVO();
                    temp.setFoodid(item.getId());
                    temp.setFoodName(item.getName());
                    temp.setNum(item.getItemQuantity());
                    resItems.add(temp);
                }

                OutFoodVO outfood = new OutFoodVO();
                outfood.setUserid(bundle.getInt("userid"));
                outfood.setFoodlist(resItems);
                outfood.setPayway("线上支付");
                outfood.setName(bundle.getString("username"));
                outfood.setPhone(checkphone.getText().toString());
                outfood.setAddress(dizhi.getText().toString()+""); //地址
                outfood.setReachtime(peisong.getText().toString()+"");//送达时间
                outfood.setAccount(""+total); //合计费用
                outfood.setSendAccount("50"); //配送费  50
                outfood.setDescription(beizhu.getText().toString()); // 备注

                Gson g = new Gson();
                String outf = g.toJson(outfood);
//                try {
//                    outf = URLEncoder.encode(g.toJson(outfood),"UTF-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }

                String a1 = checkphone.getText().toString();
                String a2 = peisong.getText().toString();
                String a3 = dizhi.getText().toString();


                //这里task
                if(TextUtils.isEmpty(a1.trim())){
                    Toast.makeText(getActivity(),"收货电话不能为空！",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(a2.trim())){
                    Toast.makeText(getActivity(),"配送时间不能为空！",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(a3.trim())){
                    Toast.makeText(getActivity(),"收货地址不能为空！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),outf,Toast.LENGTH_SHORT).show();
                    OutFoodTask outFood = new OutFoodTask();
                    outFood.execute(outf);
                }


            }
        });

        return view;
    }

    private class OutFoodTask extends AsyncTask<String,Void,Integer> {


        @Override
        protected Integer doInBackground(String... strings) {

            netWorkCon net = new netWorkCon(getActivity());

            int returnCode = 0;

            try{
                returnCode = net.OutFood(strings[0]);

            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }

            return new Integer(returnCode);
        }

        @Override
        protected void onPostExecute(Integer returnCode) {

//            Intent intent = getActivity().getIntent();

            Toast.makeText(getActivity(),"订外卖成功，您的外卖编号："+returnCode,Toast.LENGTH_SHORT).show();

//            startActivity(intent);


        }
    }


}
