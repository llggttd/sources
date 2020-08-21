/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.service;

import static com.example.admin.mapper.UserDynamicSqlSupport.status;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.consts.Common;
import com.example.admin.consts.StatusEnum;
import com.example.admin.helper.DateUtils;
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

    public Boolean addUser(User user) {
        if (user == null
            || StringUtils.isAnyBlank(user.getUsername(), user.getPassword(), user.getUsername())) {
            throw new RuntimeException(Common.DATA_IS_NULL);
        }
        user.setStatus(StatusEnum.ENABLE.getStatus());
        String now = DateUtils.formatDate(new Date());
        user.setTimeCreated(now);
        user.setTimeUpdated(now);
        return userMapper.insert(user) > 0;
    }

    public Boolean updateUser(User user) {
        if (user == null || user.getId() == null) {
            throw new RuntimeException(Common.DATA_IS_NULL);
        }
        user.setTimeUpdated(DateUtils.formatDate(new Date()));
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    public List<User> getUserList(Integer page, Integer size) {
        page = page == null || page < 1 ? 1 : page;
        size = size == null ? 20 : size;
        int limit = size;
        int offset = (page - 1) * size;
        return userMapper.select(c -> c.where(status, isEqualTo(StatusEnum.ENABLE.getStatus()))
            .limit(limit).offset(offset));
    }
}
