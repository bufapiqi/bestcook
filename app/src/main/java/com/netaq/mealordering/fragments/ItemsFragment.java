package com.netaq.mealordering.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.netaq.mealordering.R;
import com.netaq.mealordering.activity.MainActivity;
import com.netaq.mealordering.adapters.menuItem.MenuItemsAdapter;
import com.netaq.mealordering.classes.MenuItems;

import java.util.ArrayList;

import developer.shivam.perfecto.OnNetworkRequest;
import developer.shivam.perfecto.Perfecto;

/**
 * Created by Deena on 01/10/2017.
 */

public class ItemsFragment extends Fragment {
    View view;
     RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    //declare the cart button that will call the cartFragment and inflate the orderList items onto the recycler of the cart layout

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.category_item,container,false);
        progressBar =  view.findViewById(R.id.firstBar);
            //getting the category item position from activity
           Bundle bundle=this.getArguments();

        final int order = bundle.getInt("ORDER");
        // Integer categoryPosition = Integer.parseInt(orderArgument);

         // call the network based on that position
        //extract the data from network response
        //display that data in list


//        categoryPosition = 0;
        switch (order){
//
            case 0:
                Perfecto.with(getContext())
                        .fromUrl(" https://api.myjson.com/bins/18sabx")
                        .ofTypeGet()
                        .connect(new OnNetworkRequest() {
                            @Override
                            public void onStart() {

                            }

                            @Override
                            public void onSuccess(String response) {
                                    Gson gson = new Gson();

                                MenuItems[] menuConvertedObj = gson.fromJson(response,MenuItems[].class);
//                                String itemName =  menuConvertedObj[0].getName();
//                                int itemPrice=  menuConvertedObj[0].getPrice();
//                                String itemImage= menuConvertedObj[0].getImage();
                              //passing array of items to adapter
                                MenuItemsAdapter menuItemsAdapter =new MenuItemsAdapter(menuConvertedObj);
                                recyclerView = view.findViewById(R.id.menu_item_rv);

                                layoutManager =new LinearLayoutManager(getContext());

                                recyclerView.setLayoutManager(layoutManager);
                                recyclerView.setAdapter(menuItemsAdapter);
                              //  getActivity().setTitle("Snacks");
                                progressBar.setVisibility(view.GONE);

                             }

                            @Override
                            public void onFailure(int i, String s, String s1) {

                            }
                        });

                break;


            case 1:


                Perfecto.with(getContext())
                        .fromUrl(" https://api.myjson.com/bins/19z5jh")
                        .ofTypeGet()
                        .connect(new OnNetworkRequest() {
                            @Override
                            public void onStart() {

                            }

                            @Override
                            public void onSuccess(String s) {
                                Gson gson = new Gson();

                                MenuItems[] statrterConvertedObj = gson.fromJson(s,MenuItems[].class);

                                MenuItemsAdapter menuItemsAdapter =new MenuItemsAdapter(statrterConvertedObj);
                                recyclerView =(RecyclerView) view.findViewById(R.id.menu_item_rv);

                                layoutManager =new LinearLayoutManager(getContext());
                                recyclerView.setLayoutManager(layoutManager);

                                recyclerView.setAdapter(menuItemsAdapter);
                               // getActivity().setTitle("Starters");
                                progressBar.setVisibility(view.GONE);



                            }

                            @Override
                            public void onFailure(int i, String s, String s1) {

                            }
                        });
        break;

        case 2:
                Perfecto.with(getContext())
                        .fromUrl("https://api.myjson.com/bins/wth2l")
                        .ofTypeGet()
                        .connect(new OnNetworkRequest() {
                            @Override
                            public void onStart() {

                            }

                            @Override
                            public void onSuccess(String s) {
                                Gson gson =new Gson();
                                MenuItems[] sandwichConvertedObj =gson.fromJson(s,MenuItems[].class);
                                MenuItemsAdapter menuItemsAdapter = new MenuItemsAdapter(sandwichConvertedObj);

                                recyclerView =  view.findViewById(R.id.menu_item_rv);
                                layoutManager = new LinearLayoutManager(getContext());
                                recyclerView.setLayoutManager(layoutManager);

                                recyclerView.setAdapter(menuItemsAdapter);
                              //  getActivity().setTitle("Sandwiches");
                                progressBar.setVisibility(view.GONE);
                            }

                            @Override
                            public void onFailure(int i, String s, String s1) {

                            }
                        });
        break;

            case 3:

                Perfecto.with(getContext())
                       .fromUrl("https://api.myjson.com/bins/a7031")
                        .ofTypeGet()
                        .connect(new OnNetworkRequest() {
                            @Override
                            public void onStart() {

                            }

                            @Override
                            public void onSuccess(String s) {
                                        Gson gson =new Gson();
                                MenuItems[] steaksConvertedObj = gson.fromJson(s,MenuItems[].class);

                                MenuItemsAdapter menuItemsAdapter =new MenuItemsAdapter(steaksConvertedObj);
                                recyclerView = view.findViewById(R.id.menu_item_rv);
                                layoutManager =new LinearLayoutManager(getContext());
                                recyclerView.setLayoutManager(layoutManager);

                               recyclerView.setAdapter(menuItemsAdapter);
                               // getActivity().setTitle("Steaks");
                                progressBar.setVisibility(view.GONE);


                            }

                            @Override
                            public void onFailure(int i, String s, String s1) {

                            }
                        });
                break;

            case 4:
                Perfecto.with(getContext())
                        .fromUrl("https://api.myjson.com/bins/16zzil")
                        .ofTypeGet()
                        .connect(new OnNetworkRequest() {
                            @Override
                            public void onStart() {

                            }

                            @Override
                            public void onSuccess(String s) {
                                        Gson gson=new Gson();
                                MenuItems[] menuItemses = gson.fromJson(s,MenuItems[].class);

                                MenuItemsAdapter menuItemsAdapter =new MenuItemsAdapter(menuItemses);
                                recyclerView= view.findViewById(R.id.menu_item_rv);

                                layoutManager=new LinearLayoutManager(getContext());
                                recyclerView.setLayoutManager(layoutManager);

                                recyclerView.setAdapter(menuItemsAdapter);
                                getActivity().setTitle("Beverages");
                                progressBar.setVisibility(view.GONE);
                            }

                            @Override
                            public void onFailure(int i, String s, String s1) {

                            }
                        });
                break;
    }
  return view;
 }

}

