package com.example.admin.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ConfigDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.948+08:00", comments="Source Table: config")
    public static final Config config = new Config();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.949+08:00", comments="Source field: config.id")
    public static final SqlColumn<Integer> id = config.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.95+08:00", comments="Source field: config.name")
    public static final SqlColumn<String> name = config.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.95+08:00", comments="Source field: config.value")
    public static final SqlColumn<String> value = config.value;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.95+08:00", comments="Source field: config.type")
    public static final SqlColumn<String> type = config.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.95+08:00", comments="Source field: config.enable")
    public static final SqlColumn<Integer> enable = config.enable;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.95+08:00", comments="Source field: config.time_created")
    public static final SqlColumn<String> timeCreated = config.timeCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.951+08:00", comments="Source field: config.time_updated")
    public static final SqlColumn<String> timeUpdated = config.timeUpdated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.949+08:00", comments="Source Table: config")
    public static final class Config extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> value = column("value", JDBCType.VARCHAR);

        public final SqlColumn<String> type = column("type", JDBCType.VARCHAR);

        public final SqlColumn<Integer> enable = column("enable", JDBCType.INTEGER);

        public final SqlColumn<String> timeCreated = column("time_created", JDBCType.VARCHAR);

        public final SqlColumn<String> timeUpdated = column("time_updated", JDBCType.VARCHAR);

        public Config() {
            super("config");
        }
    }
}