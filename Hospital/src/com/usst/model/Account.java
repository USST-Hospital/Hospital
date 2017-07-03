package com.usst.model;

public class Account {
    private Integer account;

    private String password;

    private String power;

    public Account(Integer account, String password, String power) {
        this.account = account;
        this.password = password;
        this.power = power;
    }

    public Account() {

    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }
}