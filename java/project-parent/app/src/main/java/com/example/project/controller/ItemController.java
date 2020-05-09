/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dal.entity.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Guotao.Liu
 * @version : ItemController.java, v 0.1 2020-05-07 15:56 lgt Exp $
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @RequestMapping("/query")
    public Map<String, Object> getItem(String id, String name) {
        Item item = new Item();
        item.setId(id);
        item.setName(name);
        Map<String, Object> result = new HashMap<>();
        result.put("item", item);
        return result;
    }
}
