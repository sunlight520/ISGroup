package com.is.isgroup.util;

public class Result {
    private int code = 200;
    private String msg = "操作成功";
    private Object data;

    public Result(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result(Object data){
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
