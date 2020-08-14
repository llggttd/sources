/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.vo;

import lombok.Data;

/**
 * @author Guotao.Liu
 * @version : ResourceVO.java, v 0.1 2020-08-14 14:20 lgt Exp $
 */
@Data
public class ResourceVO {

    private Integer resourceId;

    private String  resourceName;

    private String  resourceType;

    private Integer resourceOrder;

    private String  resourceIcon;

    private String  resourceSign;

    private String  resourceUri;

    private Integer parentId;

}
