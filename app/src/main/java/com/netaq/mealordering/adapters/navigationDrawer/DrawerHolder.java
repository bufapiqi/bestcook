package com.netaq.mealordering.adapters.navigationDrawer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.netaq.mealordering.R;

/**
 * Created by Deena on 01/10/2017.
 */

class DrawerHolder extends RecyclerView.ViewHolder{

    public TextView itemTitle;
    public RelativeLayout parent;
    public DrawerHolder(View itemView) {
        super(itemView);

        itemTitle =(TextView) itemView.findViewById(R.id.nav_row_name);
        parent = (RelativeLayout)itemView.findViewById(R.id.name_parent);

    }
}
