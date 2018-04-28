package com.netaq.mealordering.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.netaq.mealordering.R;
import com.netaq.mealordering.classes.MenuItems;
import com.netaq.mealordering.fragments.CartFragment;
import com.netaq.mealordering.fragments.MainMenuFragment;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.netaq.mealordering.classes.MenuItems.orderList;

/**
 * Created by Deena on 15/10/2017.
 *
 * 列表细节Actitvity
 */

public class ItemDetailsActivity extends AppCompatActivity
{


    ImageView itemImg;
    public TextView nameItem, priceItem, categoryItem,countofItem;
    EditText specialComments;
    Button addItemBtn,incrementBtn,decrementBtn;
    String itemNameIntent,itemImgIntent;
    int itemPriceIntent,itemCategoryIntent,itemId,itemQuantity,itemPosition;
    MenuItems menuItem;
    Toolbar itemDetailToolbar;
    ImageButton itemDetailCartBtn;
    TextView itemDetailToolbarTtitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // getActionBar().setTitle("Item Details");
        setContentView(R.layout.item_details_layout);

        itemImg = (ImageView) findViewById(R.id.item_detail_img);
        nameItem = (TextView) findViewById(R.id.item_detail_name);
        priceItem = (TextView) findViewById(R.id.item_detail_price);
        categoryItem = (TextView) findViewById(R.id.item_detail_category);
        specialComments = (EditText) findViewById(R.id.comments_text);
        addItemBtn = (Button) findViewById(R.id.detail_add_btn);
        countofItem = (TextView) findViewById(R.id.detail_count_tv);
        incrementBtn = (Button) findViewById(R.id.details_item_increase);
        decrementBtn = (Button) findViewById(R.id.details_item_decrease);

        itemDetailToolbar =(Toolbar) findViewById(R.id.item_toolbar);
        //itemDetailCartBtn =(ImageButton) findViewById(R.id.item_detail_cart) ;
        itemDetailToolbarTtitle =(TextView) findViewById(R.id.item_detail_title) ;

       // itemDetailToolbar.setTitle("Item Details");


        //recieving data of item attributes from menuItemsAdapter

        itemPosition = getIntent().getExtras().getInt("item_position");
        itemNameIntent = getIntent().getStringExtra("item_name");
        itemPriceIntent = getIntent().getExtras().getInt("item_price");
        itemCategoryIntent = getIntent().getExtras().getInt("item_category");
        itemImgIntent = getIntent().getStringExtra("item_image");
        itemId = getIntent().getExtras().getInt("item_id");
        itemQuantity = getIntent().getExtras().getInt("item_quantity");

        Picasso.with(getApplicationContext()).load(itemImgIntent).into(itemImg);


        menuItem = new MenuItems(itemId, itemCategoryIntent, itemNameIntent, itemPriceIntent, itemImgIntent, itemQuantity);

        String categoryNameConverted = Integer.toString(itemCategoryIntent);

        switch (categoryNameConverted) {
            case "0":
                categoryNameConverted = "Snacks";
                categoryItem.setText("(" + categoryNameConverted + ")");

                break;
            case "1":
                categoryNameConverted = "Starters";
                categoryItem.setText("(" + categoryNameConverted + ")");

                break;
            case "2":
                categoryNameConverted = "Sandwiches";
                categoryItem.setText("(" + categoryNameConverted + ")");

                break;
            case "3":
                categoryNameConverted = "Steaks";
                categoryItem.setText("(" + categoryNameConverted + ")");

                break;
            case "4":
                categoryNameConverted = "Beverages";

                categoryItem.setText("(" + categoryNameConverted + ")");
                break;
        }


        nameItem.setText(itemNameIntent);
        priceItem.setText(Integer.toString(itemPriceIntent));
        countofItem.setText(Integer.toString(menuItem.getItemQuantity()));

        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(menuItem.getItemQuantity()==0){
                    Toast.makeText(ItemDetailsActivity.this, "Please specify quantity", Toast.LENGTH_SHORT).show();

                }
               else if (MenuItems.orderList.isEmpty()) {
                    MenuItems.orderList.add(menuItem);
                    Toast.makeText(ItemDetailsActivity.this, "This item is added", Toast.LENGTH_SHORT).show();
                    MenuItems.orderList.size();
                    menuItem.getItemQuantity();
                    AddItemToCart(menuItem);

                } else {
                    boolean itemNotFound = false;
                    for (int i = 0; i < orderList.size(); i++) {
                        MenuItems alreadyordered = orderList.get(i);
                        if (alreadyordered.getId() == menuItem.getId()) {
                            AddItemToCart(menuItem);
                            itemNotFound = true;


                            Toast.makeText(ItemDetailsActivity.this, "This item is added", Toast.LENGTH_SHORT).show();

                            break;
                        } else {
                            continue;
                        }
                    }
                    if (itemNotFound == false) {
                        Toast.makeText(ItemDetailsActivity.this, "This item is added", Toast.LENGTH_SHORT).show();

                        MenuItems.orderList.add(menuItem);
                        AddItemToCart(menuItem);

                    }
                }


            }

            private void AddItemToCart(MenuItems selecteItem) {
                final int itemQuantity = selecteItem.getItemQuantity();
                selecteItem.setItemQuantity(itemQuantity);
                countofItem.setText(Integer.toString(itemQuantity));
                Toast.makeText(ItemDetailsActivity.this, "This item is added", Toast.LENGTH_SHORT).show();


            }


        });


        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                menuItem.getItemQuantity();
                menuItem.setItemQuantity(menuItem.getItemQuantity() + 1);
                countofItem.setText(Integer.toString(menuItem.getItemQuantity()));

                menuItem.getItemQuantity();


                //  MenuItems.orderList.add(menuItem);


            }
        });

        decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int itemCount = menuItem.getItemQuantity();
                if (itemCount == 0) {
                    Toast.makeText(ItemDetailsActivity.this, "This is the minimum quantity", Toast.LENGTH_SHORT).show();
                    menuItem.getItemQuantity();
                  //  MenuItems.orderList.get(itemPosition).setItemQuantity( menuItem.getItemQuantity());


                } else {
                    menuItem.setItemQuantity(menuItem.getItemQuantity() - 1);
                    countofItem.setText(Integer.toString(menuItem.getItemQuantity()));
                   // MenuItems.orderList.get(itemPosition).setItemQuantity( menuItem.getItemQuantity());

                }
            }
        });




//        itemDetailCartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment fragment = new CartFragment();
//
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.content_main,fragment);
//                ft.commit();
//                itemDetailToolbar.setTitle("My Cart");
//
//
//
//
//            }
//        });


    }


}
