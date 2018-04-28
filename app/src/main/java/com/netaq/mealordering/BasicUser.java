package com.netaq.mealordering;

/**
 * Created by RABOOK on 2018/4/28.
 */

public class BasicUser {

    private int id;
    private String account;
    private String password;
    private String addess;
    private String photoLink;

    public BasicUser(){
        super();
    }

    public BasicUser(int id, String account, String password, String addess, String photoLink) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.addess = addess;
        this.photoLink = photoLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddess() {
        return addess;
    }

    public void setAddess(String addess) {
        this.addess = addess;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }
}
