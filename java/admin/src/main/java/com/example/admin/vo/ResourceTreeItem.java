/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.vo;

import java.util.List;

import com.example.admin.helper.TreeNode;

import lombok.Data;

/**
 * @author Guotao.Liu
 * @version : ResourceTreeItem.java, v 0.1 2020-08-20 10:21 lgt Exp $
 */
@Data
public class ResourceTreeItem implements TreeNode<ResourceTreeItem> {

    private Integer                id;

    private Integer                parentId;

    private String                 title;

    private String                 href;

    private Boolean                disabled;

    private Boolean                checked;

    private Boolean                spread;

    private List<ResourceTreeItem> children;

}
