package com.netaq.mealordering.adapters.Cart;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.netaq.mealordering.R;
import com.netaq.mealordering.classes.MenuItems;
import com.netaq.mealordering.fragments.CartFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;
import static com.netaq.mealordering.classes.MenuItems.orderList;

/**
 * Created by Deena on 04/10/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartViewholder>{

    private View view;
    private ArrayList<MenuItems> cartItemsList;
    private int itemQuantity;
    private onQuantityModification quantityModificationInterface;


    public void setQuantityModificationInterface(onQuantityModification quantityModificationInterface) {
        this.quantityModificationInterface = quantityModificationInterface;
    }

    public CartAdapter(ArrayList<MenuItems> cartItemsList) {
        this.cartItemsList = cartItemsList;
    }


    @Override
    public CartViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_viewholder,parent,false);

        CartViewholder cartViewHolder = new CartViewholder(view);
        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(final CartViewholder holder, final int position) {

        final String orderName = orderList.get(position).getName();
        holder.itemName.setText(orderName);
        holder.itemPrice.setText((Integer.toString(orderList.get(position).getPrice())) + " Dhs.");

        itemQuantity = orderList.get(position).getItemQuantity();
        holder.orderCount.setText((Integer.toString(orderList.get(position).getItemQuantity())));
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Toast.makeText(view.getContext(), orderList.get(position).getName() + " is removed", Toast.LENGTH_LONG).show();
                orderList.remove(orderList.get(position));

                orderList.size();
                notifyDataSetChanged();
                quantityModificationInterface.onQuantityModified();

            }
        });

        holder.rmvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (orderList.get(position).getItemQuantity() == 1) {
                    //remove item if count was 1
                    Toast.makeText(view.getContext(), orderList.get(position).getName() + " is removed", Toast.LENGTH_LONG).show();
                    orderList.remove(orderList.get(position));
                    orderList.size();
                    notifyDataSetChanged();
                    quantityModificationInterface.onQuantityModified();
                } else {
                    orderList.get(position).setItemQuantity((orderList.get(position).getItemQuantity()) - 1);
                    notifyDataSetChanged();
                    quantityModificationInterface.onQuantityModified();
                }
            }
        });

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                orderList.get(position).setItemQuantity((orderList.get(position).getItemQuantity()) + 1);
                notifyDataSetChanged();
                quantityModificationInterface.onQuantityModified();
            }
        });
     }
    @Override
    public int getItemCount() {
        return orderList.size();
    }


    public interface onQuantityModification{
        void onQuantityModified();
    }
}
