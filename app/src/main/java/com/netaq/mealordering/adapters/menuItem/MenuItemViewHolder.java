package com.netaq.mealordering.adapters.menuItem;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.netaq.mealordering.R;

/**
 * Created by Deena on 03/10/2017.
 */

class MenuItemViewHolder extends RecyclerView.ViewHolder{
     TextView itemName,itemPrice;
    ImageView itemImage;
    Button addBtn,doneBtn;

    public MenuItemViewHolder(View itemView) {
        super(itemView);
        //doneBtn = itemView.findViewById(R.id.done_btn);
        itemName =itemView.findViewById(R.id.menu_item_title);
        itemPrice=itemView.findViewById(R.id.menu_item_price);
        itemImage = itemView.findViewById(R.id.menu_item_img);
        addBtn= itemView.findViewById(R.id.add_item_btn);



    }
}
