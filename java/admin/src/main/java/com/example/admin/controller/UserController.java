/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.helper.HttpResult;
import com.example.admin.model.User;
import com.example.admin.service.UserService;

/**
 * @author Guotao.Liu
 * @version : UserController.java, v 0.1 2020-08-12 17:17 lgt Exp $
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @GetMapping("/info")
    @ResponseBody
    public HttpResult getUserInfo(Integer userId) {
        User user = userService.getUserById(userId);
        return HttpResult.success(user);
    }

    @GetMapping("/list")
    @ResponseBody
    public HttpResult getUserList() {
        List<User> users = userService.getAllUser();
        return HttpResult.success(users);
    }
}
