/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.helper.HttpResult;
import com.example.admin.model.Role;
import com.example.admin.service.RoleService;
import com.example.admin.vo.BooleanResult;
import com.example.admin.vo.RoleVO;

/**
 * @author Guotao.Liu
 * @version : RoleController.java, v 0.1 2020-08-13 11:42 lgt Exp $
 */
@RestController
@RequestMapping("role")
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/add")
    public HttpResult addRole(RoleVO roleVO) {
        Role role = new Role();
        role.setRoleName(roleVO.getRoleName());
        role.setRoleSign(roleVO.getRoleSign());
        role.setDescription(roleVO.getDescription());
        Boolean success = roleService.addRole(role);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/edit")
    public HttpResult editRole(RoleVO roleVO) {
        Role role = new Role();
        role.setId(roleVO.getRoleId());
        role.setRoleName(roleVO.getRoleName());
        role.setRoleSign(roleVO.getRoleSign());
        role.setDescription(roleVO.getDescription());
        Boolean success = roleService.updateRole(role);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/enable")
    public HttpResult enableRole(Integer roleId) {
        Role role = new Role();
        role.setId(roleId);
        role.setStatus(1);
        Boolean success = roleService.updateRole(role);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/disable")
    public HttpResult disableRole(Integer roleId) {
        Role role = new Role();
        role.setId(roleId);
        role.setStatus(0);
        Boolean success = roleService.updateRole(role);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/list")
    public HttpResult listRole() {
        List<Role> roleList = roleService.getRoleList();
        List<RoleVO> result = new ArrayList<>();
        roleList.forEach(role -> {
            RoleVO roleVO = new RoleVO();
            roleVO.setRoleId(role.getId());
            roleVO.setRoleName(role.getRoleName());
            roleVO.setRoleSign(role.getRoleSign());
            roleVO.setDescription(role.getDescription());
            roleVO.setEnable(role.getStatus() > 0);
            result.add(roleVO);
        });
        return HttpResult.success(result);
    }
}
