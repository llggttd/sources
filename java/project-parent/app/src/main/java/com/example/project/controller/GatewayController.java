/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.project.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.common.HttpResult;

/**
 * @author Guotao.Liu
 * @version : GatewayController.java, v 0.1 2020-05-09 16:06 lgt Exp $
 */
@RestController
public class GatewayController extends BaseController {

    @Resource
    private ActionAdapter actionAdapter;

    @RequestMapping("/gateway")
    public HttpResult<?> gateway(HttpServletRequest request, HttpServletResponse response) {
        return actionAdapter.action(request, response);
    }
}
