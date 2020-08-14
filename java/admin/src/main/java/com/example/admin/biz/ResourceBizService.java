/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.model.Resource;
import com.example.admin.service.ResourceService;

/**
 * @author Guotao.Liu
 * @version : ResourceBizService.java, v 0.1 2020-08-14 14:00 lgt Exp $
 */
@Service
public class ResourceBizService {

    private final ResourceService resourceService;

    @Autowired
    public ResourceBizService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public Boolean addResource(Resource resource) {
        return resourceService.addResource(resource);
    }

    public Boolean updateResource(Resource resource) {
        return resourceService.updateResource(resource);
    }

    public List<Resource> getResourceList(Integer page, Integer limit) {
        return resourceService.getAllResource(page, limit);
    }
}
