package com.netaq.mealordering;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class Reserve {

    private int id;
    private String time;
    private Integer num;
    private String phone;
    private String description;
    private Integer userid;
    private String name;

    public Reserve() {
        super();
    }

    public Reserve(int id, String time, Integer num, String phone, String description, Integer userid, String name) {
        this.id = id;
        this.time = time;
        this.num = num;
        this.phone = phone;
        this.description = description;
        this.userid = userid;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
