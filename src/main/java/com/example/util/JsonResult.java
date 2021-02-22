package com.example.util;

import lombok.Data;

/**
 * @author Lucky
 * @version 1.0.0
 * @date 2020/8/31 2:01
 * @copyright 老九学堂
 */
public class JsonResult<T> {

    private int code;
    private T data;
    private String msg;
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
