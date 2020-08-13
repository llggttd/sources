package com.example.admin.model;

import javax.annotation.Generated;

public class User {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.013+08:00", comments="Source field: user.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.013+08:00", comments="Source field: user.username")
    private String username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.mobile")
    private String mobile;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.status")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.time_created")
    private String timeCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.time_updated")
    private String timeUpdated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.013+08:00", comments="Source field: user.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.013+08:00", comments="Source field: user.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.username")
    public String getUsername() {
        return username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.username")
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.mobile")
    public String getMobile() {
        return mobile;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.status")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.time_created")
    public String getTimeCreated() {
        return timeCreated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.time_created")
    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.time_updated")
    public String getTimeUpdated() {
        return timeUpdated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.014+08:00", comments="Source field: user.time_updated")
    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }
}