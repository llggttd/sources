/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.vo;

import lombok.Data;

/**
 * @author Guotao.Liu
 * @version : RoleVO.java, v 0.1 2020-08-13 11:47 lgt Exp $
 */
@Data
public class RoleVO {

    private Integer roleId;

    private String  roleName;

    private String  roleSign;

    private String  description;

    private Boolean enable;
}
