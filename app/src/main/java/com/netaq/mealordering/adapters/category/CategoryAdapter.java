package com.netaq.mealordering.adapters.category;

import android.app.Activity;
import android.app.admin.ConnectEvent;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.netaq.mealordering.R;

import org.w3c.dom.Text;

import static com.netaq.mealordering.R.id.parent;

/**
 * Created by Deena on 01/10/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
Context context;


public class ViewHolder extends RecyclerView.ViewHolder
{
    public ImageView imageView;
    public TextView itemTitle,itemPrice;
    public ImageButton addBtn;

    public ViewHolder(View itemView) {
        super(itemView);

        itemTitle=(TextView) itemView.findViewById(R.id.menu_item_title);
        itemPrice= itemView.findViewById(R.id.menu_item_price);
        addBtn=itemView.findViewById(R.id.add_item_btn);
        imageView=  itemView.findViewById(R.id.menu_item_img);
    }
}

    public CategoryAdapter(Context context){
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder,parent,false);
     ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
