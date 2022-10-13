package com.is.isgroup.util;

import java.io.Serializable;
import java.util.List;

//Json格式的数据进行相应
public class JsonResult<E> implements Serializable {
    private Integer state;
    private String message;
    private List<E> list;
    private E data;
    public JsonResult(){

    }

    public JsonResult(Integer state, String message, List<E> list, E data) {
        this.state = state;
        this.message = message;
        this.list = list;
        this.data = data;
    }

    public JsonResult(Integer state, List<E> list) {
        this.state = state;
        this.list = list;
    }

    public JsonResult(Integer state) {
        this.state = state;
    }
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
