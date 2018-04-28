package com.netaq.mealordering.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.netaq.mealordering.R;

/**
 * Created by Netaq on 10/22/2017.
 */

public class CheckoutFragment extends Fragment {


    TextView subTotal, deliveryTotal, totalCharge,toolbarTtile;
    Button zhifubt;

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.checkout_layout,container,false);
        subTotal = view.findViewById(R.id.sub_total_price);
        deliveryTotal = view.findViewById(R.id.delivery_tax);
        totalCharge = view.findViewById(R.id.total_charge);
        zhifubt = view.findViewById(R.id.zhifubutton);

        subTotal.setText("0 Dhs.");
        totalCharge.setText("0 Dhs.");
        deliveryTotal.setText("0 Dhs.");

        zhifubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里填写支付的URL
            }
        });

        return view;
    }

}
