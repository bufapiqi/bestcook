package com.netaq.mealordering;

import java.math.BigDecimal;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class food {

    private int id;
    private String name;
    private BigDecimal price;
    private String type;
    private Integer storeid;
    private String photolink;

    public food() {
        super();
    }

    public food(int id, String name, BigDecimal price, String type, Integer storeid, String photolink) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.storeid = storeid;
        this.photolink = photolink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getPhotolink() {
        return photolink;
    }

    public void setPhotolink(String photolink) {
        this.photolink = photolink;
    }
}
