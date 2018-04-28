package com.netaq.mealordering.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netaq.mealordering.R;

/**
 * Created by Deena on 01/10/2017.
 */

public class InformationFragment extends Fragment{

    View view;
    ImageView imageView;
    TextView location,phone,website;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.info_layout,container,false);
        imageView=view.findViewById(R.id.info_logo);
        phone=view.findViewById(R.id.phone_tv);
        website=view.findViewById(R.id.site_tv);
        location=view.findViewById(R.id.location_tv);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Call us");

    }

}
