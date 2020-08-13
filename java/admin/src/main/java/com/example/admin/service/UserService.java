/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.mapper.UserMapper;
import com.example.admin.model.User;

/**
 * @author Guotao.Liu
 * @version : UserService.java, v 0.1 2020-08-11 14:07 lgt Exp $
 */
@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId).orElseThrow(RuntimeException::new);
    }

    public List<User> getAllUser() {
        return userMapper.select(c -> c);
    }
}
