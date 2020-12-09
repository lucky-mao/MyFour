package com.cykj.bean;

public class Menu {
    private int mid;
    private String mName;
    private String url;
    private int fid;
    private String belong;

    public Menu() {
    }

    public Menu(int mid, String mName, String url, int fid, String belong) {
        this.mid = mid;
        this.mName = mName;
        this.url = url;
        this.fid = fid;
        this.belong = belong;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }
}
