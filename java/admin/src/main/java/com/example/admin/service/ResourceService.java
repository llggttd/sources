/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.service;

import static com.example.admin.mapper.ResourceDynamicSqlSupport.status;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.consts.Common;
import com.example.admin.consts.StatusEnum;
import com.example.admin.helper.DateUtils;
import com.example.admin.mapper.ResourceMapper;
import com.example.admin.model.Resource;

/**
 * @author Guotao.Liu
 * @version : ResourceService.java, v 0.1 2020-08-11 14:07 lgt Exp $
 */
@Service
public class ResourceService {

    private final ResourceMapper resourceMapper;

    @Autowired
    public ResourceService(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    public Boolean addResource(Resource resource) {
        if (resource == null || StringUtils.isAnyBlank(resource.getResourceName(),
            resource.getResourceSign(), resource.getResourceType())) {
            throw new RuntimeException(Common.DATA_IS_NULL);
        }
        resource.setResourceIcon(StringUtils.defaultString(resource.getResourceIcon()));
        resource.setResourceUri(StringUtils.defaultString(resource.getResourceUri()));
        if (resource.getParentId() == null) {
            resource.setParentId(0);
        }
        if (resource.getResourceOrder() == null) {
            resource.setResourceOrder(0);
        }
        resource.setStatus(StatusEnum.ENABLE.getStatus());
        String now = DateUtils.formatDate(new Date());
        resource.setTimeCreated(now);
        resource.setTimeUpdated(now);
        return resourceMapper.insert(resource) > 0;
    }

    public Boolean updateResource(Resource resource) {
        if (resource == null || resource.getId() == null) {
            throw new RuntimeException(Common.DATA_IS_NULL);
        }
        resource.setTimeUpdated(DateUtils.formatDate(new Date()));
        return resourceMapper.updateByPrimaryKeySelective(resource) > 0;
    }

    public Resource getResource(Integer resourceId) {
        if (resourceId == null) {
            throw new RuntimeException(Common.DATA_IS_NULL);
        }
        return resourceMapper.selectByPrimaryKey(resourceId).orElse(null);
    }

    public List<Resource> getAllResource(Integer page, Integer size) {
        page = page == null || page < 1 ? 1 : page;
        size = size == null ? 20 : size;
        int limit = size;
        int offset = (page - 1) * size;
        return resourceMapper.select(c -> c.where(status, isEqualTo(StatusEnum.ENABLE.getStatus()))
            .limit(limit).offset(offset));
    }
}
