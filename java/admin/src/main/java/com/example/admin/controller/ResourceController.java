/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.biz.ResourceBizService;
import com.example.admin.consts.StatusEnum;
import com.example.admin.helper.HttpResult;
import com.example.admin.vo.BooleanResult;
import com.example.admin.vo.ResourceVO;

/**
 * @author Guotao.Liu
 * @version : ResourceController.java, v 0.1 2020-08-13 11:42 lgt Exp $
 */
@RestController
@RequestMapping("resource")
public class ResourceController extends BaseController {

    @Resource
    private ResourceBizService resourceBizService;

    @ResponseBody
    @RequestMapping("/add")
    public HttpResult addResource(ResourceVO resourceVO) {
        com.example.admin.model.Resource resource = new com.example.admin.model.Resource();
        BeanUtils.copyProperties(resourceVO, resource);
        Boolean success = resourceBizService.addResource(resource);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/edit")
    public HttpResult editResource(ResourceVO resourceVO) {
        com.example.admin.model.Resource resource = new com.example.admin.model.Resource();
        BeanUtils.copyProperties(resourceVO, resource);
        resource.setId(resourceVO.getResourceId());
        Boolean success = resourceBizService.updateResource(resource);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public HttpResult deleteResource(Integer resourceId) {
        com.example.admin.model.Resource resource = new com.example.admin.model.Resource();
        resource.setId(resourceId);
        resource.setStatus(StatusEnum.DISABLE.getStatus());
        Boolean success = resourceBizService.updateResource(resource);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/list")
    public HttpResult listResource(Integer page, Integer limit) {
        List<com.example.admin.model.Resource> resourceList = resourceBizService
            .getResourceList(page, limit);
        List<ResourceVO> result = new ArrayList<>();
        resourceList.forEach(resource -> {
            ResourceVO resourceVO = new ResourceVO();
            BeanUtils.copyProperties(resource, resourceVO);
            resourceVO.setResourceId(resource.getId());
            result.add(resourceVO);
        });
        return HttpResult.success(result);
    }
}
