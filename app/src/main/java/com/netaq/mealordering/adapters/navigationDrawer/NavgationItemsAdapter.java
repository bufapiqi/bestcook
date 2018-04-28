package com.netaq.mealordering.adapters.navigationDrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netaq.mealordering.R;
import com.netaq.mealordering.classes.NavigationItems;



/**
 * Created by Deena on 01/10/2017.
 */

public class NavgationItemsAdapter extends RecyclerView.Adapter<DrawerHolder> {

    View view;
    private NavigationItems[] mDataset;
    NavdrawerInterface categoryItemInterface;

    public NavgationItemsAdapter(NavigationItems[] mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public DrawerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_drawer_item,parent,false);
        DrawerHolder viewHolder=new DrawerHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(DrawerHolder holder, int position) {

        holder.itemTitle.setText(mDataset[position].getCategory());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        holder.itemTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("NavAdapter","Row Clicked");
//                categoryItemInterface.onCategoryClicked();
//                //Toast.makeText(view.getContext(),"You cicked here",Toast.LENGTH_LONG).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public interface NavdrawerInterface{

        void onCategoryClicked();

    }
}
