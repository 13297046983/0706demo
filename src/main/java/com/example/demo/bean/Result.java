package com.example.demo.bean;

public class Result <T>{
    private T data;//数据
    private String msg;//返回的信息
    private int code;//返回码

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    /*
    * 有数据返回，返回的信息操作成功，数据为data
    * */
    public Result(T data){
        this.code=200;
        this.msg="操作成功";
        this.data=data;
    }
}
