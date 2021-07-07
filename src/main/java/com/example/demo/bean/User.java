package com.example.demo.bean;

public class User {
    private int id;
    private String username;
    private String pwd;
    private String sex;

    public User(int id,String username,String pwd,String sex){
        this.id=id;
        this.username=username;
        this.pwd=pwd;
        this.sex=sex;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
