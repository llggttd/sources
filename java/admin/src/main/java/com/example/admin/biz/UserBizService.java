/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.dto.UserDTO;
import com.example.admin.helper.MD5Utils;
import com.example.admin.model.User;
import com.example.admin.service.UserService;

/**
 * @author Guotao.Liu
 * @version : UserBizService.java, v 0.1 2020-08-20 15:49 lgt Exp $
 */
@Service
public class UserBizService {

    private UserService userService;

    @Autowired
    public UserBizService(UserService userService) {
        this.userService = userService;
    }

    public Boolean addUser(UserDTO userDTO) {
        User user = new User();
        user.setMobile(userDTO.getMobile());
        user.setUsername(userDTO.getUsername());
        user.setPassword(MD5Utils.md5(userDTO.getPassword()));
        return userService.addUser(user);
    }

    public Boolean updateUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setMobile(userDTO.getMobile());
        user.setUsername(userDTO.getUsername());
        if (StringUtils.isNotBlank(userDTO.getPassword())) {
            user.setPassword(MD5Utils.md5(MD5Utils.md5(userDTO.getPassword())));
        }
        return userService.updateUser(user);
    }

    public List<UserDTO> getUserList(Integer page, Integer size) {
        List<UserDTO> result = new ArrayList<>();
        List<User> list = userService.getUserList(page, size);
        list.forEach(item -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(item.getId());
            userDTO.setUsername(item.getUsername());
            userDTO.setMobile(item.getMobile());
            userDTO.setStatus(item.getStatus());
            userDTO.setTimeCreated(item.getTimeCreated());
            result.add(userDTO);
        });
        return result;
    }
}
