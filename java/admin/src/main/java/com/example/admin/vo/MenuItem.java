/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.vo;

import java.util.List;

import lombok.Data;

/**
 * @author Guotao.Liu
 * @version : MenuItem.java, v 0.1 2020-08-14 17:07 lgt Exp $
 */
@Data
public class MenuItem {

    private String         name;

    private String         title;

    private String         icon;

    private String         jump;

    private List<MenuItem> list;
}
