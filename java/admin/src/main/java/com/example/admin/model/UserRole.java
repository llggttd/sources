package com.example.admin.model;

import javax.annotation.Generated;

public class UserRole {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.user_id")
    private Integer userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.role_id")
    private Integer roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.status")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.02+08:00", comments="Source field: user_role.time_created")
    private String timeCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.02+08:00", comments="Source field: user_role.time_updated")
    private String timeUpdated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.user_id")
    public Integer getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.role_id")
    public Integer getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.role_id")
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.019+08:00", comments="Source field: user_role.status")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.02+08:00", comments="Source field: user_role.status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.02+08:00", comments="Source field: user_role.time_created")
    public String getTimeCreated() {
        return timeCreated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.02+08:00", comments="Source field: user_role.time_created")
    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.02+08:00", comments="Source field: user_role.time_updated")
    public String getTimeUpdated() {
        return timeUpdated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.02+08:00", comments="Source field: user_role.time_updated")
    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }
}