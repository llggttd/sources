/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.project.controller.action;

/**
 * @author Guotao.Liu
 * @version : ActionEnum.java, v 0.1 2020-05-09 17:28 lgt Exp $
 */
public enum ActionMeta {

    /**
     * USER_LOGIN
     */
    USER_LOGIN("user.login", "用户登陆", false),

    /**
     * USER_LOGOUT
     */
    USER_LOGOUT("user.logout", "用户登出", true);

    private String  name;
    private String  description;
    private Boolean token;

    ActionMeta(String name, String description, Boolean token) {
        this.name = name;
        this.description = description;
        this.token = token;
    }

    public static ActionMeta getByName(String name) {
        for (ActionMeta item : ActionMeta.values()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getToken() {
        return token;
    }

    public void setToken(Boolean token) {
        this.token = token;
    }
}
