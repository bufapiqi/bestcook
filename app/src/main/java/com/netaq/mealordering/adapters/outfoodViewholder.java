package com.netaq.mealordering.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.netaq.mealordering.OutFoodVO;
import com.netaq.mealordering.R;

/**
 * Created by RABOOK on 2018/4/29.
 */

public class outfoodViewholder extends RecyclerView.ViewHolder{

    TextView outfoodName,outfoodNamelabel;
    TextView addresslabel;
    TextView reach,reachlabel;
    TextView heji,hejilabel;
    TextView beizhu,beizhulabel;

    private OutFoodVO outfood;

    public void bindOutFood(OutFoodVO out){
        outfood = out;

        outfoodName.setText(outfood.getName());
        addresslabel.setText("收货地址：                                          "+outfood.getAddress());
        reach.setText(outfood.getReachtime());
        heji.setText(outfood.getAccount());
        beizhu.setText(outfood.getDescription());

    }


    public outfoodViewholder(View itemView) {
        super(itemView);

        outfoodName = itemView.findViewById(R.id.outfoodname);
        outfoodNamelabel = itemView.findViewById(R.id.outfoodNamelabel);
        addresslabel = itemView.findViewById(R.id.outfoodaddressLabel);
        reach = itemView.findViewById(R.id.outfoodreachtime);
        reachlabel = itemView.findViewById(R.id.outfoodreachtimelabel);
        heji = itemView.findViewById(R.id.account);
        hejilabel = itemView.findViewById(R.id.accountlabel);
        beizhu = itemView.findViewById(R.id.beizhubeizhu);
        beizhulabel = itemView.findViewById(R.id.beizhubeizhulabel);

    }
}
