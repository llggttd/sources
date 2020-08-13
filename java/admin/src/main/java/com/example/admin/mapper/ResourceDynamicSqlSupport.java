package com.example.admin.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ResourceDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.993+08:00", comments="Source Table: resource")
    public static final Resource resource = new Resource();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.993+08:00", comments="Source field: resource.id")
    public static final SqlColumn<Integer> id = resource.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.994+08:00", comments="Source field: resource.resource_name")
    public static final SqlColumn<String> resourceName = resource.resourceName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.994+08:00", comments="Source field: resource.resource_type")
    public static final SqlColumn<String> resourceType = resource.resourceType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.994+08:00", comments="Source field: resource.resource_order")
    public static final SqlColumn<Integer> resourceOrder = resource.resourceOrder;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.994+08:00", comments="Source field: resource.resource_icon")
    public static final SqlColumn<String> resourceIcon = resource.resourceIcon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.994+08:00", comments="Source field: resource.resource_sign")
    public static final SqlColumn<String> resourceSign = resource.resourceSign;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.994+08:00", comments="Source field: resource.resource_uri")
    public static final SqlColumn<String> resourceUri = resource.resourceUri;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.994+08:00", comments="Source field: resource.parent_id")
    public static final SqlColumn<Integer> parentId = resource.parentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.994+08:00", comments="Source field: resource.status")
    public static final SqlColumn<Integer> status = resource.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.994+08:00", comments="Source field: resource.time_created")
    public static final SqlColumn<String> timeCreated = resource.timeCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.995+08:00", comments="Source field: resource.time_updated")
    public static final SqlColumn<String> timeUpdated = resource.timeUpdated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.993+08:00", comments="Source Table: resource")
    public static final class Resource extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> resourceName = column("resource_name", JDBCType.VARCHAR);

        public final SqlColumn<String> resourceType = column("resource_type", JDBCType.VARCHAR);

        public final SqlColumn<Integer> resourceOrder = column("resource_order", JDBCType.INTEGER);

        public final SqlColumn<String> resourceIcon = column("resource_icon", JDBCType.VARCHAR);

        public final SqlColumn<String> resourceSign = column("resource_sign", JDBCType.VARCHAR);

        public final SqlColumn<String> resourceUri = column("resource_uri", JDBCType.VARCHAR);

        public final SqlColumn<Integer> parentId = column("parent_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<String> timeCreated = column("time_created", JDBCType.VARCHAR);

        public final SqlColumn<String> timeUpdated = column("time_updated", JDBCType.VARCHAR);

        public Resource() {
            super("resource");
        }
    }
}