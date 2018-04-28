package com.netaq.mealordering;

import java.math.BigDecimal;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class Outfood {

    private int id;
    private String payway; //支付方式？
    private String address;
    private String reachtime;
    private BigDecimal account;
    private BigDecimal sendzccount;
    private String decription;
    private Integer userid;

    public Outfood() {
        super();
    }

    public Outfood(int id, String payway, String address, String reachtime, BigDecimal account, BigDecimal sendzccount, String decription, Integer userid) {
        this.id = id;
        this.payway = payway;
        this.address = address;
        this.reachtime = reachtime;
        this.account = account;
        this.sendzccount = sendzccount;
        this.decription = decription;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReachtime() {
        return reachtime;
    }

    public void setReachtime(String reachtime) {
        this.reachtime = reachtime;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public BigDecimal getSendzccount() {
        return sendzccount;
    }

    public void setSendzccount(BigDecimal sendzccount) {
        this.sendzccount = sendzccount;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
