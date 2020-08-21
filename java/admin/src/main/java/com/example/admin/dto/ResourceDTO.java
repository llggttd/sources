/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.dto;

import lombok.Data;

/**
 * @author Guotao.Liu
 * @version : ResourceDTO.java, v 0.1 2020-08-20 14:32 lgt Exp $
 */
@Data
public class ResourceDTO {

    private Integer id;

    private String  resourceName;

    private String  resourceType;

    private Integer resourceOrder;

    private String  resourceIcon;

    private String  resourceSign;

    private String  resourceUri;

    private Integer parentId;

    private String  parentName;

    private Integer status;

    private String  timeCreated;

    private String  timeUpdated;
}
