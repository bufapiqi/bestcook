package com.netaq.mealordering.adapters.Cart;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.netaq.mealordering.R;

/**
 * Created by Deena on 04/10/2017.
 */

class CartViewholder extends RecyclerView.ViewHolder{

    TextView itemName,itemPrice,itemCategory,orderCount;
   public  ImageButton deleteBtn;
    Button addBtn,rmvBtn;



    public CartViewholder(View itemView) {
        super(itemView);

        itemName = itemView.findViewById(R.id.cart_title_tv);
        itemPrice =itemView.findViewById(R.id.cart_price_tv);
      //  itemCategory =itemView.findViewById(R.id.cart_item_category);
        orderCount =itemView.findViewById(R.id.order_count_tv);
        addBtn=itemView.findViewById(R.id.add_item_cart);
        rmvBtn =itemView.findViewById(R.id.decrease_item_cart);
        deleteBtn =itemView.findViewById(R.id.cart_delete_btn);
    }


}
