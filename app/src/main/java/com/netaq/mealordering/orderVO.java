package com.netaq.mealordering;

/**
 * Created by RABOOK on 2018/4/29.
 */

public class orderVO  {

    private Integer foodid;
    private String foodName;
    private Integer num;

    public orderVO() {
        super();
    }

    public orderVO(Integer foodid, String foodName, Integer num) {
        this.foodid = foodid;
        this.foodName = foodName;
        this.num = num;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
