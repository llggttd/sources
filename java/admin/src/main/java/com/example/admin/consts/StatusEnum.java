/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.consts;

/**
 * @author Guotao.Liu
 * @version : StatusEnum.java, v 0.1 2020-08-14 11:26 lgt Exp $
 */
public enum StatusEnum {

    /**
     * 禁用
     */
    DISABLE(0),
    /**
     * 启用
     */
    ENABLE(1);

    /**
     * 状态
     */
    private final int status;

    StatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static StatusEnum getByStatus(int status) {
        for (StatusEnum item : StatusEnum.values()) {
            if (item.getStatus() == status) {
                return item;
            }
        }
        throw new RuntimeException(
            "status[" + status + "] not found in " + StatusEnum.class.getName());
    }
}
