package com.example.admin.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source Table: user")
    public static final User user = new User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source field: user.id")
    public static final SqlColumn<Integer> id = user.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source field: user.username")
    public static final SqlColumn<String> username = user.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source field: user.password")
    public static final SqlColumn<String> password = user.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source field: user.mobile")
    public static final SqlColumn<String> mobile = user.mobile;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source field: user.status")
    public static final SqlColumn<Integer> status = user.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source field: user.time_created")
    public static final SqlColumn<String> timeCreated = user.timeCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source field: user.time_updated")
    public static final SqlColumn<String> timeUpdated = user.timeUpdated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source Table: user")
    public static final class User extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> mobile = column("mobile", JDBCType.VARCHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<String> timeCreated = column("time_created", JDBCType.VARCHAR);

        public final SqlColumn<String> timeUpdated = column("time_updated", JDBCType.VARCHAR);

        public User() {
            super("user");
        }
    }
}