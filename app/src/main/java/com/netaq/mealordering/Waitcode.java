package com.netaq.mealordering;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class Waitcode {

    private int id;
    private String waitcode;
    private Integer num;
    private String name;
    private String time;
    private String phone;
    private Integer userid;

    public Waitcode() {
        super();
    }

    public Waitcode(int id, String waitcode, Integer num, String name, String time, String phone, Integer userid) {
        this.id = id;
        this.waitcode = waitcode;
        this.num = num;
        this.name = name;
        this.time = time;
        this.phone = phone;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaitcode() {
        return waitcode;
    }

    public void setWaitcode(String waitcode) {
        this.waitcode = waitcode;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
