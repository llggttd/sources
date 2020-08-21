/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author Guotao.Liu
 * @version : UserVO.java, v 0.1 2020-08-20 15:53 lgt Exp $
 */
@Data
public class UserVO {

    private Integer id;

    private String  username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String  password;

    private String  mobile;

    private Integer status;

    private String  timeCreated;

}
