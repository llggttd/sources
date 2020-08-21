/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.helper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Guotao.Liu
 * @version : TreeNodeHelper.java, v 0.1 2020-08-20 11:26 lgt Exp $
 */
public class TreeNodeHelper<T extends TreeNode<T>> {

    /**
     * 把list转成树型结构
     * @param list
     * @return
     */
    public List<T> getTree(List<T> list) {
        return list.stream().filter(item -> item.getParentId() == 0)
            .peek(item -> item.setChildren(getChildren(item, list))).collect(Collectors.toList());
    }

    /**
     * 递归查找子元素
     * @param parent
     * @param list
     * @return
     */
    private List<T> getChildren(T parent, List<T> list) {
        return list.stream().filter(item -> item.getParentId().equals(parent.getId()))
            .peek(item -> item.setChildren(getChildren(item, list))).collect(Collectors.toList());
    }
}
