/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.biz.UserBizService;
import com.example.admin.dto.UserDTO;
import com.example.admin.helper.HttpResult;
import com.example.admin.vo.BooleanResult;
import com.example.admin.vo.MenuItem;
import com.example.admin.vo.UserVO;

/**
 * @author Guotao.Liu
 * @version : UserController.java, v 0.1 2020-08-12 17:17 lgt Exp $
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserBizService userBizService;

    @GetMapping("/add")
    @ResponseBody
    public HttpResult addUser(UserVO userVO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userVO, userDTO);
        Boolean success = userBizService.addUser(userDTO);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @GetMapping("/edit")
    @ResponseBody
    public HttpResult editUser(UserVO userVO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userVO, userDTO);
        Boolean success = userBizService.updateUser(userDTO);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @GetMapping("/del")
    @ResponseBody
    public HttpResult delUser(Integer userId) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userId);
        Boolean success = userBizService.updateUser(userDTO);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @GetMapping("/list")
    @ResponseBody
    public HttpResult getUserList(Integer page, Integer limit) {
        List<UserDTO> list = userBizService.getUserList(page, limit);
        List<UserVO> result = new ArrayList<>();
        list.forEach(item -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(item, userVO);
            result.add(userVO);
        });
        return HttpResult.success(result);
    }

    @GetMapping("/menu")
    @ResponseBody
    public HttpResult getUserMenu() {
        List<MenuItem> list = new ArrayList<>();
        return HttpResult.success(list);
    }
}
