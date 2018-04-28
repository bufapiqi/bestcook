package com.netaq.mealordering.adapters.menuItem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.netaq.mealordering.R;
import com.netaq.mealordering.activity.ItemDetailsActivity;
import com.netaq.mealordering.adapters.Cart.CartAdapter;
import com.netaq.mealordering.classes.MenuItems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.netaq.mealordering.classes.MenuItems.orderList;

/**
 * Created by Deena on 03/10/2017.
 */

public class MenuItemsAdapter extends RecyclerView.Adapter<MenuItemViewHolder> {

    View view;
    String name;
    MenuItems[] itemseDataset;
     Context context;
    public MenuItemsAdapter(MenuItems[] menuConvertedObj) {
        this.itemseDataset=menuConvertedObj;
    }
    @Override
    public MenuItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        view = LayoutInflater.from(context).inflate(R.layout.item_viewholder,parent,false);

        MenuItemViewHolder menuItemViewHolder =new MenuItemViewHolder(view);
        return menuItemViewHolder;
    }
    @Override
    public void onBindViewHolder(final MenuItemViewHolder holder, final int position) {

        holder.itemPrice.setText("Price: "+(Integer.toString(itemseDataset[position].getPrice())) + " Dhs.");
        holder.itemName.setText(itemseDataset[position].getName());

        String image = itemseDataset[position].getImage();
       name= itemseDataset[position].getName();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInfo;
                intentInfo=new Intent(context, ItemDetailsActivity.class);
                intentInfo.putExtra("item_name",itemseDataset[position].getName());
                intentInfo.putExtra("item_image",itemseDataset[position].getImage());
                intentInfo.putExtra("item_price",itemseDataset[position].getPrice());
                intentInfo.putExtra("item_category",itemseDataset[position].getCategory_id());
                intentInfo.putExtra("item_id",itemseDataset[position].getId());
                intentInfo.putExtra("item_quantity",itemseDataset[position].getItemQuantity());
                intentInfo.putExtra("item_position",position);


                 context.startActivity(intentInfo);
            }
        });

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int IDofItemtobeOrdered = itemseDataset[position].getId();
                final MenuItems itemTobeOrdered= itemseDataset[position];

                if(orderList.isEmpty()){
                    orderList.add(itemTobeOrdered);
                    orderList.size();
                     itemTobeOrdered.getItemQuantity();
                    FirstTimeItem(itemTobeOrdered);

                    notifyDataSetChanged();
                    Toast.makeText(view.getContext(),itemseDataset[position].getName()+ " is added to your cart",Toast.LENGTH_LONG).show();


                }
                else
                {
                    boolean itemNotFound= false;
                    for (int i = 0; i < orderList.size(); i++) {
                        MenuItems alreadyordered = orderList.get(i);
                        if (alreadyordered.getId() == itemTobeOrdered.getId()) {
                            final int count = orderList.get(i).getItemQuantity();
                            FirstTimeItem(itemTobeOrdered);
                             itemNotFound= true;

                            notifyDataSetChanged();
                            Toast.makeText(view.getContext(),itemseDataset[position].getName()+ " is added to your cart",Toast.LENGTH_LONG).show();
                             break;                      }

                        else {
                              continue;}
                    }
                    if(itemNotFound==false)
                    {
                        orderList.add(itemTobeOrdered);
                            FirstTimeItem(itemTobeOrdered);
                            notifyDataSetChanged();
                        Toast.makeText(view.getContext(),itemseDataset[position].getName()+ " is added to your cart",Toast.LENGTH_LONG).show();

                    }
                }
                }
        });

        //setting item image after checking if item image is !null
        if(image.equals(""))
        {

            Picasso.with(context).load(R.mipmap.about_icon).into(holder.itemImage);
        }
        else
        {
            Picasso.with(context).load(itemseDataset[position].getImage()).into(holder.itemImage);
        }
    }

    private void FirstTimeItem(MenuItems itemTobeOrdered) {
        final int itemQuantity = itemTobeOrdered.getItemQuantity();
        itemTobeOrdered.setItemQuantity(itemQuantity+1);

    }


    @Override
    public int getItemCount() {
        return itemseDataset.length;
    }
}
