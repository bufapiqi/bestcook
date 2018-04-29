package com.netaq.mealordering.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netaq.mealordering.OutFoodVO;
import com.netaq.mealordering.R;

import java.util.List;

/**
 * Created by RABOOK on 2018/4/29.
 */

public class outfoodAdapters extends RecyclerView.Adapter<outfoodViewholder>{

    List<OutFoodVO> list;

    public outfoodAdapters(List<OutFoodVO> ll){
        this.list = ll;
    }

    @Override
    public outfoodViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.outfood_viewholder,parent,false);

        outfoodViewholder o = new outfoodViewholder(view);

        return o;
    }

    @Override
    public void onBindViewHolder(outfoodViewholder holder, int position) {

        OutFoodVO oo = list.get(position);

        holder.bindOutFood(oo);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
