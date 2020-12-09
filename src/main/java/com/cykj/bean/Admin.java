package com.cykj.bean;

public class Admin {
    private String uName;
    private String account;
    private String pwd;

    public Admin(String uName, String account, String pwd) {
        this.uName = uName;
        this.account = account;
        this.pwd = pwd;
    }

    public Admin() {
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
