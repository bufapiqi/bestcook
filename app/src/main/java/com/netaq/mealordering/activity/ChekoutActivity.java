package com.netaq.mealordering.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.netaq.mealordering.OutFoodVO;
import com.netaq.mealordering.R;
import com.netaq.mealordering.classes.MenuItems;
import com.netaq.mealordering.fragments.CheckoutFragment;
import com.netaq.mealordering.netWorkCon;
import com.netaq.mealordering.orderVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Netaq on 10/22/2017.
 */

public class ChekoutActivity extends AppCompatActivity {

    TextView subTotal ,finalTotal, deliveryCharge;
    Toolbar checkoutToolbar;
    int newSubPrice,itemsSize;

    Button zhifubt;

    TextView dizhilabel,peisonglabel,beizhulabel,checkphonelabel;
    EditText dizhi,peisong,beizhu,checkphone;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_layout);
        subTotal =(TextView) findViewById(R.id.sub_total_price);
        deliveryCharge =(TextView) findViewById(R.id.delivery_tax);
        finalTotal =(TextView) findViewById(R.id.total_charge);


        checkoutToolbar =(Toolbar) findViewById(R.id.checkout_toolbar);


        checkoutToolbar.setTitle("Checkout");
        subTotal.setText("0");
        deliveryCharge.setText("0");
        finalTotal.setText("0");


        //recieving subPrice from CheckoutActivity

        newSubPrice = getIntent().getExtras().getInt("subPrice");
        itemsSize =getIntent().getExtras().getInt("dataSize");
        subTotal.setText(String.valueOf(newSubPrice+" Dhs."));
        deliveryCharge.setText("50 Dhs.");
        finalTotal.setText(String.valueOf(newSubPrice+50+" Dhs."));


        zhifubt = findViewById(R.id.zhifubutton);
        dizhilabel = findViewById(R.id.peisonglabel);
        peisonglabel = findViewById(R.id.reachTimeLabel);
        beizhulabel = findViewById(R.id.beizhilabel);
        checkphonelabel = findViewById(R.id.checkphonelabel);

        Log.i("有没有到这里怕","点击到这里了没有");

        dizhi = findViewById(R.id.peisongEdit);
        peisong = findViewById(R.id.reachTimeEdit);
        beizhu = findViewById(R.id.beizhuEdit);
        checkphone = findViewById(R.id.checkoutphoneEdit);

        zhifubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里填写支付的URL

                Log.i("支付有没有","点击到这里了没有");

                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                int total = bundle.getInt("subPrice")+50; //总支出

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

                String a1 = checkphone.getText().toString();
                String a2 = peisong.getText().toString();
                String a3 = dizhi.getText().toString();

                //这里task
//                OutFoodTask outFood = new OutFoodTask();
//                outFood.execute(outf);

                //这里task
                if(TextUtils.isEmpty(a1.trim())){
                    Toast.makeText(ChekoutActivity.this,"收货电话不能为空！",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(a2.trim())){
                    Toast.makeText(ChekoutActivity.this,"配送时间不能为空！",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(a3.trim())){
                    Toast.makeText(ChekoutActivity.this,"收货地址不能为空！",Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(ChekoutActivity.this,outf,Toast.LENGTH_SHORT).show();
                    OutFoodTask outFood = new OutFoodTask();
                    outFood.execute(outf);
                }

            }
        });

    }


    private class OutFoodTask extends AsyncTask<String,Void,Integer> {


        @Override
        protected Integer doInBackground(String... strings) {

            netWorkCon net = new netWorkCon(getApplicationContext());

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

            Toast.makeText(ChekoutActivity.this,"订外卖成功，您的外卖编号："+returnCode,Toast.LENGTH_SHORT).show();

//            startActivity(intent);


        }
    }

}
