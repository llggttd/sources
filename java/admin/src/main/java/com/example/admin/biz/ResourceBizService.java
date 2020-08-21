/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.dto.ResourceDTO;
import com.example.admin.model.Resource;
import com.example.admin.service.ResourceService;

/**
 * @author Guotao.Liu
 * @version : ResourceBizService.java, v 0.1 2020-08-14 14:00 lgt Exp $
 */
@Service
public class ResourceBizService {

    private final ResourceService      resourceService;

    private final Map<Integer, String> cache = new HashMap<>();

    @Autowired
    public ResourceBizService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public Boolean addResource(ResourceDTO resourceDTO) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceDTO, resource);
        return resourceService.addResource(resource);
    }

    public Boolean updateResource(ResourceDTO resourceDTO) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceDTO, resource);
        return resourceService.updateResource(resource);
    }

    public List<ResourceDTO> getResourceList(Integer page, Integer limit) {
        List<ResourceDTO> result = new ArrayList<>();
        List<Resource> list = resourceService.getAllResource(page, limit);
        list.forEach(item -> {
            ResourceDTO resourceDTO = new ResourceDTO();
            BeanUtils.copyProperties(item, resourceDTO);
            resourceDTO.setParentName(getParentResourceName(item.getParentId()));
            result.add(resourceDTO);
        });
        return result;
    }

    private String getParentResourceName(Integer resourceId) {
        if (!cache.containsKey(resourceId)) {
            Resource resource = resourceService.getResource(resourceId);
            cache.put(resourceId,
                resource != null ? resource.getResourceName() : StringUtils.EMPTY);
        }
        return cache.get(resourceId);
    }

}
