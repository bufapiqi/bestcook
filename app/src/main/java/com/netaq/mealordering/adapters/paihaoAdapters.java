package com.netaq.mealordering.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netaq.mealordering.R;
import com.netaq.mealordering.Waitcode;

import java.util.List;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class paihaoAdapters extends RecyclerView.Adapter<paihaoViewholder>{

    List<Waitcode> list;

    public paihaoAdapters(List<Waitcode> list){
        this.list = list;
    }


    @Override
    public paihaoViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paihao_viewholder,parent,false);

        paihaoViewholder holder = new paihaoViewholder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(paihaoViewholder holder, int position) {

        Waitcode wait = list.get(position);

        holder.bindPaihao(wait);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
