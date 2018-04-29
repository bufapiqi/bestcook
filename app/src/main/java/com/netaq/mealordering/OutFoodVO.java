package com.netaq.mealordering;

import java.util.List;

/**
 * Created by RABOOK on 2018/4/29.
 */

public class OutFoodVO {

    private int userid;
    private List<orderVO> foodlist;
    private String payway;
    private String name;
    private String phone;
    private String address;
    private String reachtime;
    private String account; //合计费用 含配送费
    private String sendAccount; //配送费
    private String description;


    public OutFoodVO() {
        super();
    }

    public OutFoodVO(int userid, List<orderVO> foodlist, String payway, String name, String phone, String address, String reachtime, String account, String sendAccount, String description) {
        this.userid = userid;
        this.foodlist = foodlist;
        this.payway = payway;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.reachtime = reachtime;
        this.account = account;
        this.sendAccount = sendAccount;
        this.description = description;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<orderVO> getFoodlist() {
        return foodlist;
    }

    public void setFoodlist(List<orderVO> foodlist) {
        this.foodlist = foodlist;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSendAccount() {
        return sendAccount;
    }

    public void setSendAccount(String sendAccount) {
        this.sendAccount = sendAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
