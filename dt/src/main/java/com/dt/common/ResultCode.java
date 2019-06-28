package com.dt.common;

public enum ResultCode {
    SUCCESS(0, "成功"),
    WRONG(1, "操作失败"),
    UNAUTH(401, "未授权"),
    PARAMETER_ERROR(400, "参数错误"),
    HYSTRIX_TIME_OUT(-1, "未授权");

    private int code;
    private String info;

    private ResultCode(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }
}
