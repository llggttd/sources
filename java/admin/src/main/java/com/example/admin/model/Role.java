package com.example.admin.model;

import javax.annotation.Generated;

public class Role {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.998+08:00", comments="Source field: role.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.998+08:00", comments="Source field: role.role_name")
    private String roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.999+08:00", comments="Source field: role.role_sign")
    private String roleSign;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15+08:00", comments="Source field: role.description")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.status")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.time_created")
    private String timeCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.time_updated")
    private String timeUpdated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.998+08:00", comments="Source field: role.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.998+08:00", comments="Source field: role.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.999+08:00", comments="Source field: role.role_name")
    public String getRoleName() {
        return roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.999+08:00", comments="Source field: role.role_name")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15+08:00", comments="Source field: role.role_sign")
    public String getRoleSign() {
        return roleSign;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15+08:00", comments="Source field: role.role_sign")
    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15+08:00", comments="Source field: role.description")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.status")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.time_created")
    public String getTimeCreated() {
        return timeCreated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.time_created")
    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.time_updated")
    public String getTimeUpdated() {
        return timeUpdated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source field: role.time_updated")
    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }
}