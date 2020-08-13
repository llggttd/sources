/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.helper;

/**
 * @author Guotao.Liu
 * @version : HttpResult.java, v 0.1 2020-08-12 17:23 lgt Exp $
 */
public class HttpResult {

    /**
     * 结果状态定义
     */
    enum Status {

        /**
         * 请求成功
         */
        SUCCESS(0, "请求成功"),

        /**
         * 服务异常
         */
        FAILURE(1, "服务异常"),

        /**
         * 参数异常
         */
        PARAM_ERROR(2, "参数异常");

        private int    status;

        private String message;

        Status(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 结果状态码
     */
    private int    status;

    /**
     * 结果状态描述
     */
    private String message;

    /**
     * 结果数据
     */
    private Object data = new Object();

    private HttpResult(Status status) {
        this.status = status.getStatus();
        this.message = status.getMessage();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public static HttpResult success(Object result) {
        HttpResult httpResult = new HttpResult(Status.SUCCESS);
        httpResult.data = result;
        return httpResult;
    }

    public static HttpResult failure() {
        return new HttpResult(Status.FAILURE);
    }

    public static HttpResult failure(String message) {
        HttpResult httpResult = new HttpResult(Status.FAILURE);
        httpResult.message = message;
        return httpResult;
    }
}
