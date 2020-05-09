/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.project.common;

/**
 * @author Guotao.Liu
 * @version : HttpResult.java, v 0.1 2020-05-09 15:51 lgt Exp $
 */
public class HttpResult<T> {

    private Integer code;

    private String  msg;

    private T       data;

    public static HttpResult<Object> build(Integer code, String msg) {
        return new HttpResult<>(code, msg, new Object());
    }

    public static <E> HttpResult<E> build(Integer code, String msg, E data) {
        return new HttpResult<>(code, msg, data);
    }

    HttpResult(Integer code, String msg, T data) {
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
