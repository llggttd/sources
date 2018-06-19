package top.crazyman.quick.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import top.crazyman.quick.entities.Entities;
import top.crazyman.quick.enums.EnabledEnum;
import top.crazyman.quick.enums.EntitiesTypeEnum;

import java.util.List;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/5/29
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@Mapper
public interface EntitiesMapper {

    @Select("select * from entities where guid = #{guid}")
    @Results(id = "entitiesMap", value = {
            @Result(column = "guid", property = "guid", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(column = "type", property = "type", javaType = EntitiesTypeEnum.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "subtype", property = "subtype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "owner_guid", property = "ownerGuid", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(column = "site_guid", property = "siteGuid", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(column = "container_guid", property = "containerGuid", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(column = "access_id", property = "accessId", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "time_created", property = "timeCreated", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "time_updated", property = "timeUpdated", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "last_action", property = "lastAction", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "enabled", property = "enabled", javaType = EnabledEnum.class, jdbcType = JdbcType.VARCHAR),
    })
    Entities selectEntitiesByGuid(Long guid);

    @Select("select * from entities where type = #{type}")
    @ResultMap("entitiesMap")
    List<Entities> selectEntitiesByType(EntitiesTypeEnum type);



}
