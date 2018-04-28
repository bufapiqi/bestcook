package com.netaq.mealordering.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.netaq.mealordering.R;
import com.netaq.mealordering.activity.ChekoutActivity;
import com.netaq.mealordering.activity.MainActivity;
import com.netaq.mealordering.adapters.Cart.CartAdapter;
import com.netaq.mealordering.classes.MenuItems;

import java.util.ArrayList;

import static com.netaq.mealordering.classes.MenuItems.orderList;

/**
 * Created by Deena on 05/10/2017.
 */

public class CartFragment extends Fragment implements CartAdapter.onQuantityModification{
    RecyclerView recyclerView;
    CartAdapter cartAdapter;
   // TextView subTotal, deliveryTotal, totalCharge,toolbarTtile;
    View view;
    public int subPrice,listSize;
    RecyclerView.LayoutManager cartLayoutManager;
    Button checkoutBtn;
    ArrayList<MenuItems> orderList;
    private int temp;
    Context context;
    private int itemCount,itemValue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.cart_layout, container, false);
        recyclerView = view.findViewById(R.id.cart_list_rv);
       // subTotal = view.findViewById(R.id.sub_total_price);
       // deliveryTotal = view.findViewById(R.id.delivery_tax);
       // totalCharge = view.findViewById(R.id.total_charge);
        checkoutBtn = view.findViewById(R.id.check_out_btn);
//        subTotal.setText("0 Dhs.");
//        totalCharge.setText("0 Dhs.");
//        deliveryTotal.setText("0 Dhs.");

        //    call Caradapter and pass cart arrayList of orders
        orderList = MenuItems.getOrderList();
        CartAdapter cartAdapter = new CartAdapter(orderList);
        cartAdapter.setQuantityModificationInterface(this);

        cartLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(cartLayoutManager);
        recyclerView.setAdapter(cartAdapter);

        CalculateTotalPrice();
        return view;
    }

    private void CalculateTotalPrice() {
           // subPrice=0;
             for(int i=0; i<orderList.size(); i++)
            {
                itemCount= orderList.get(i).getItemQuantity();
                 itemValue=  orderList.get(i).getPrice();
                subPrice += (itemCount*itemValue);

            }





//        subTotal.setText(String.valueOf(subPrice+" Dhs."));
//        deliveryTotal.setText("5 Dhs.");
//
//        totalCharge.setText(String.valueOf(subPrice+5+" Dhs."));

        //intent to load CheckoutActivity class

        checkoutBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                { Intent intentinfo ;
                    intentinfo =new Intent(getActivity().getApplication(), ChekoutActivity.class);
                    intentinfo.putExtra("subPrice",subPrice);
                    // Toast.makeText(view.getContext(), "Order is placed Successfully.", Toast.LENGTH_LONG).show();
                startActivity(intentinfo);

                }
            });
}

    @Override
    public void onQuantityModified() {
        CalculateTotalPrice();
    }


}