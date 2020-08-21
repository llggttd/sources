/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.biz.ResourceBizService;
import com.example.admin.consts.StatusEnum;
import com.example.admin.dto.ResourceDTO;
import com.example.admin.helper.HttpResult;
import com.example.admin.helper.TreeNodeHelper;
import com.example.admin.vo.BooleanResult;
import com.example.admin.vo.ResourceTreeItem;
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
        ResourceDTO resourceDTO = new ResourceDTO();
        BeanUtils.copyProperties(resourceVO, resourceDTO);
        Boolean success = resourceBizService.addResource(resourceDTO);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/edit")
    public HttpResult editResource(ResourceVO resourceVO) {
        ResourceDTO resourceDTO = new ResourceDTO();
        BeanUtils.copyProperties(resourceVO, resourceDTO);
        resourceDTO.setId(resourceVO.getResourceId());
        Boolean success = resourceBizService.updateResource(resourceDTO);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public HttpResult deleteResource(Integer resourceId) {
        ResourceDTO resourceDTO = new ResourceDTO();
        resourceDTO.setId(resourceId);
        resourceDTO.setStatus(StatusEnum.DISABLE.getStatus());
        Boolean success = resourceBizService.updateResource(resourceDTO);
        BooleanResult result = new BooleanResult();
        result.setSuccess(success);
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/list")
    public HttpResult listResource(Integer page, Integer limit) {
        List<ResourceDTO> resourceList = resourceBizService.getResourceList(page, limit);
        List<ResourceVO> result = new ArrayList<>();
        resourceList.forEach(resource -> {
            ResourceVO resourceVO = new ResourceVO();
            BeanUtils.copyProperties(resource, resourceVO);
            resourceVO.setResourceId(resource.getId());
            result.add(resourceVO);
        });
        return HttpResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/tree")
    public HttpResult treeResource() {
        List<ResourceDTO> resourceList = resourceBizService.getResourceList(1, 10000);
        List<ResourceTreeItem> list = resourceList.stream().map(item -> {
            ResourceTreeItem treeItem = new ResourceTreeItem();
            treeItem.setId(item.getId());
            treeItem.setParentId(item.getParentId());
            treeItem.setTitle(item.getResourceName());
            treeItem.setDisabled(item.getStatus() <= 0);
            treeItem.setChildren(new ArrayList<>());
            treeItem.setSpread(false);
            treeItem.setChecked(false);
            treeItem.setHref(item.getResourceUri());
            return treeItem;
        }).collect(Collectors.toList());
        List<ResourceTreeItem> tree = new TreeNodeHelper<ResourceTreeItem>().getTree(list);
        return HttpResult.success(tree);
    }
}
