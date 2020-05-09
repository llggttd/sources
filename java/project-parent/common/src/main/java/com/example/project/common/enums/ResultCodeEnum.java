/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.project.common.enums;

/**
 * @author Guotao.Liu
 * @version : ResultCodeEnum.java, v 0.1 2020-05-09 17:18 lgt Exp $
 */
public enum ResultCodeEnum {

    /**
     * SUCCESS
     */
    SUCCESS(0, "SUCCESS"),

    /**
     * EXCEPTION
     */
    EXCEPTION(1, "EXCEPTION");

    /**
     * 状态码
     */
    private int    code;

    /**
     * 状态描述
     */
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
