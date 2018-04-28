package com.netaq.mealordering.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.netaq.mealordering.R;
import com.netaq.mealordering.Waitcode;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class paihaoViewholder extends RecyclerView.ViewHolder{

    TextView xuhao,xuhaolabel;
    TextView chifan,chifanlabel;
    TextView xingming,xingminglabel;
    TextView dianhua,dianhualabel;
    TextView shijian,shijianlabel;

    private Waitcode waitItem;

    public void bindPaihao(Waitcode wait){
        waitItem = wait;

        xuhao.setText(wait.getWaitcode());
        chifanlabel.setText("吃饭人数：                                          "+wait.getNum());
        xingming.setText(wait.getName());
        dianhua.setText(wait.getPhone());
        shijian.setText(wait.getTime());

    }

    public paihaoViewholder(View itemView) {
        super(itemView);

        xuhao = (TextView)itemView.findViewById(R.id.xuhao);
        xingming = (TextView)itemView.findViewById(R.id.yudingxingming);
        dianhua =(TextView) itemView.findViewById(R.id.yudingdianhua);
        shijian = (TextView)itemView.findViewById(R.id.yudingshijian);

        chifanlabel = (TextView)itemView.findViewById(R.id.chifanlabel);
        xuhaolabel = (TextView)itemView.findViewById(R.id.xuhaolabel);
        xingminglabel = (TextView)itemView.findViewById(R.id.yudingxingminglabel);
        dianhualabel = (TextView)itemView.findViewById(R.id.yudingdianhualabel);
        shijianlabel = (TextView)itemView.findViewById(R.id.yudingshijianlabei);



    }
}
