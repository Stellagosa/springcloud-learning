package com.ellaend.cloud.common;

/**
 * @author ellaend
 * @date 2021/1/4 15:55
 * version 1.0
 */
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
