package com.atagotech.qk.bean.common;


import com.atagotech.qk.bean.ResponseConfig;

public class ResponseBean<T> {
    private int code;
    private String msg;
    private T data;

    public ResponseBean() {
    }
    public ResponseBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseBean(T t) {
        this(ResponseConfig.Code.SUCCESS, ResponseConfig.MSG.SUCCESS, t);
    }

    public ResponseBean(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
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


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
