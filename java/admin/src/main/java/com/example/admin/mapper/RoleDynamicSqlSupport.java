package com.example.admin.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source Table: role")
    public static final Role role = new Role();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.002+08:00", comments="Source field: role.id")
    public static final SqlColumn<Integer> id = role.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.002+08:00", comments="Source field: role.role_name")
    public static final SqlColumn<String> roleName = role.roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.002+08:00", comments="Source field: role.role_sign")
    public static final SqlColumn<String> roleSign = role.roleSign;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.002+08:00", comments="Source field: role.description")
    public static final SqlColumn<String> description = role.description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.002+08:00", comments="Source field: role.status")
    public static final SqlColumn<Integer> status = role.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.002+08:00", comments="Source field: role.time_created")
    public static final SqlColumn<String> timeCreated = role.timeCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.002+08:00", comments="Source field: role.time_updated")
    public static final SqlColumn<String> timeUpdated = role.timeUpdated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.001+08:00", comments="Source Table: role")
    public static final class Role extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public final SqlColumn<String> roleSign = column("role_sign", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<String> timeCreated = column("time_created", JDBCType.VARCHAR);

        public final SqlColumn<String> timeUpdated = column("time_updated", JDBCType.VARCHAR);

        public Role() {
            super("role");
        }
    }
}