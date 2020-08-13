/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.helper.DateUtils;
import com.example.admin.mapper.RoleMapper;
import com.example.admin.model.Role;

/**
 * @author Guotao.Liu
 * @version : RoleService.java, v 0.1 2020-08-13 11:48 lgt Exp $
 */
@Service
public class RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<Role> getRoleList() {
        return roleMapper.select(c -> c);
    }

    public Boolean addRole(Role role) {
        role.setStatus(1);
        String now = DateUtils.formatDate(new Date());
        role.setTimeCreated(now);
        role.setTimeUpdated(now);
        return roleMapper.insert(role) > 0;
    }

    public Boolean updateRole(Role role) {
        role.setTimeUpdated(DateUtils.formatDate(new Date()));
        return roleMapper.updateByPrimaryKeySelective(role) > 0;
    }

}
