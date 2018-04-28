package com.netaq.mealordering.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netaq.mealordering.R;
import com.netaq.mealordering.Reserve;

import java.util.List;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class reserveAdapters extends RecyclerView.Adapter<reserveViewholder> {

    List<Reserve> list;

    public reserveAdapters(List<Reserve> list){
        this.list = list;
    }

    @Override
    public reserveViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reserve_viewholder,parent,false);

        reserveViewholder res = new reserveViewholder(view);

        return res;
    }

    @Override
    public void onBindViewHolder(reserveViewholder holder, int position) {

        Reserve res = list.get(position);

        holder.reserveName.setText(res.getName());
        holder.reserveDes.setText(res.getDescription());
        holder.reserveTime.setText(res.getTime());
        holder.reservePhone.setText(res.getPhone());
//        holder.reserveNum.setText(res.getNum());
        holder.reserveNumLabel.setText("订餐人数：                                    "+res.getNum());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
