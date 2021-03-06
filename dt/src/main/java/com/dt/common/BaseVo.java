package com.dt.common;

public class BaseVo<T> {
    private int code;
    private String msg;
    private T data;

    public BaseVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseVo() {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getInfo();
    }

    public BaseVo(T data) {
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
