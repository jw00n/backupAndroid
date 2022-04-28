package com.example.chat;

public class ChatVO {

    private int imgProfile;
    private String name;
    private String msg;
    private String time;

    public ChatVO(int imgProfile, String name, String msg, String time) {
        this.imgProfile = imgProfile;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    public ChatVO() {
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
