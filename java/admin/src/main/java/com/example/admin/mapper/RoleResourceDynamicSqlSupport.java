package com.example.admin.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleResourceDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.009+08:00", comments="Source Table: role_resource")
    public static final RoleResource roleResource = new RoleResource();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.009+08:00", comments="Source field: role_resource.id")
    public static final SqlColumn<Integer> id = roleResource.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.009+08:00", comments="Source field: role_resource.role_id")
    public static final SqlColumn<Integer> roleId = roleResource.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.009+08:00", comments="Source field: role_resource.resource_id")
    public static final SqlColumn<Integer> resourceId = roleResource.resourceId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.009+08:00", comments="Source field: role_resource.status")
    public static final SqlColumn<Integer> status = roleResource.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.01+08:00", comments="Source field: role_resource.time_created")
    public static final SqlColumn<String> timeCreated = roleResource.timeCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.01+08:00", comments="Source field: role_resource.time_updated")
    public static final SqlColumn<String> timeUpdated = roleResource.timeUpdated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.009+08:00", comments="Source Table: role_resource")
    public static final class RoleResource extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> roleId = column("role_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> resourceId = column("resource_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<String> timeCreated = column("time_created", JDBCType.VARCHAR);

        public final SqlColumn<String> timeUpdated = column("time_updated", JDBCType.VARCHAR);

        public RoleResource() {
            super("role_resource");
        }
    }
}