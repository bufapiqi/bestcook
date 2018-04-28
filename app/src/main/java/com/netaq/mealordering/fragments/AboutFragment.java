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

public class AboutFragment extends Fragment {

    View view;
    TextView textView;
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.about_layout,container,false);
        textView= view.findViewById(R.id.about_tv);
        imageView=view.findViewById(R.id.about_logo);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("About Us");
    }

}
