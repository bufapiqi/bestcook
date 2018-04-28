package com.netaq.mealordering.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.netaq.mealordering.R;

/**
 * Created by Netaq on 10/22/2017.
 */

public class ChekoutActivity extends AppCompatActivity {

    TextView subTotal ,finalTotal, deliveryCharge;
    Toolbar checkoutToolbar;
    int newSubPrice,itemsSize;


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
        deliveryCharge.setText("5 Dhs.");


        finalTotal.setText(String.valueOf(newSubPrice+5+" Dhs."));

    }
}
