/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.helper;

import java.util.List;

/**
 * @author Guotao.Liu
 * @version : TreeNode.java, v 0.1 2020-08-20 11:32 lgt Exp $
 */
public interface TreeNode<T> {

    Integer getId();

    Integer getParentId();

    void setChildren(List<T> list);
}
