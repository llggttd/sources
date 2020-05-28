/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Item;
import com.xxl.conf.core.annotation.XxlConf;

/**
 * @author Guotao.Liu
 * @version : ConfigController.java, v 0.1 2020-05-27 14:47 lgt Exp $
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @XxlConf("default.key01")
    public String  test1;

    @Value("${conf.test2}")
    private String test2;

    @Resource
    private Item   item;

    @RequestMapping("/query")
    public Map<String, Object> getConfig(String key) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("key", key);
        map.put("test1", test1);
        map.put("test2", test2);
        map.put("item", item.getName());
        return map;
    }
}
