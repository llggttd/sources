package com.example.admin.model;

import javax.annotation.Generated;

public class RoleResource {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.007+08:00", comments="Source field: role_resource.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.007+08:00", comments="Source field: role_resource.role_id")
    private Integer roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.007+08:00", comments="Source field: role_resource.resource_id")
    private Integer resourceId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.status")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.time_created")
    private String timeCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.time_updated")
    private String timeUpdated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.007+08:00", comments="Source field: role_resource.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.007+08:00", comments="Source field: role_resource.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.007+08:00", comments="Source field: role_resource.role_id")
    public Integer getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.007+08:00", comments="Source field: role_resource.role_id")
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.resource_id")
    public Integer getResourceId() {
        return resourceId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.resource_id")
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.status")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.time_created")
    public String getTimeCreated() {
        return timeCreated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.time_created")
    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.time_updated")
    public String getTimeUpdated() {
        return timeUpdated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.008+08:00", comments="Source field: role_resource.time_updated")
    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }
}