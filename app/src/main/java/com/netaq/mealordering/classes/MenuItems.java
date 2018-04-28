package com.netaq.mealordering.classes;

import java.util.ArrayList;

/**
 * Created by Deena on 03/10/2017.
 */

public class MenuItems
{


    public int id;
    public int category_id;
    public String name;
    public int price;
    public String image;
    public int itemQuantity=0;
    public static ArrayList<MenuItems> orderList =new ArrayList<MenuItems>();

    public MenuItems(int id, int category_id, String name, int price, String image, int itemQuantity) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.itemQuantity = itemQuantity;
    }

    public int getId() {
        return id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public static ArrayList<MenuItems> getOrderList() {
        return orderList;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
