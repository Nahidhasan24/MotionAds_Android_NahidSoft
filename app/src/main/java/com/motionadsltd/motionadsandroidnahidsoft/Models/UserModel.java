package com.motionadsltd.motionadsandroidnahidsoft.Models;

public class UserModel {
    private int id;
    private String name,mail,phone,type,referCode,refer,balance;

    public UserModel(int id, String name, String mail, String phone, String type, String referCode, String refer, String balance) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.type = type;
        this.referCode = referCode;
        this.refer = refer;
        this.balance = balance;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReferCode() {
        return referCode;
    }

    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
