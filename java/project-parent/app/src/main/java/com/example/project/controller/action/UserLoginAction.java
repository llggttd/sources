/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.project.controller.action;

/**
 * @author Guotao.Liu
 * @version : UserLogin.java, v 0.1 2020-05-09 17:49 lgt Exp $
 */
@ActionHandle(ActionMeta.USER_LOGIN)
public class UserLoginAction implements Action {

    /**
     * 执行流程
     *
     * @param param
     * @return
     */
    @Override
    public ActionResult execute(String param) {
        ActionResult actionResult = new ActionResult();
        actionResult.setData("login");
        return actionResult;
    }
}
