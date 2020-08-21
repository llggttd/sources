/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.dto;

import lombok.Data;

/**
 * @author Guotao.Liu
 * @version : UserDTO.java, v 0.1 2020-08-20 15:49 lgt Exp $
 */
@Data
public class UserDTO {

    private Integer id;

    private String  username;

    private String  password;

    private String  mobile;

    private Integer status;

    private String  timeCreated;

}
