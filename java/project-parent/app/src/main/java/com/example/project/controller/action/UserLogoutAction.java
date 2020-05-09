/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.project.controller.action;

import com.example.project.controller.Action;
import com.example.project.controller.ActionResult;

/**
 * @author Guotao.Liu
 * @version : UserLogin.java, v 0.1 2020-05-09 17:49 lgt Exp $
 */
@ActionHandle(ActionMeta.USER_LOGOUT)
public class UserLogoutAction implements Action {

    /**
     * 执行流程
     *
     * @param param
     * @return
     */
    @Override
    public ActionResult execute(String param) {
        ActionResult actionResult = new ActionResult();
        actionResult.setData("logout");
        return actionResult;
    }
}
