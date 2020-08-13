package com.example.admin.mapper;

import static com.example.admin.mapper.RoleResourceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.example.admin.model.RoleResource;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface RoleResourceMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.012+08:00", comments="Source Table: role_resource")
    BasicColumn[] selectList = BasicColumn.columnList(id, roleId, resourceId, status, timeCreated, timeUpdated);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.01+08:00", comments="Source Table: role_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.01+08:00", comments="Source Table: role_resource")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.01+08:00", comments="Source Table: role_resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<RoleResource> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.01+08:00", comments="Source Table: role_resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RoleResource> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.01+08:00", comments="Source Table: role_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RoleResourceResult")
    Optional<RoleResource> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.01+08:00", comments="Source Table: role_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RoleResourceResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="time_created", property="timeCreated", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_updated", property="timeUpdated", jdbcType=JdbcType.VARCHAR)
    })
    List<RoleResource> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.011+08:00", comments="Source Table: role_resource")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.011+08:00", comments="Source Table: role_resource")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.011+08:00", comments="Source Table: role_resource")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.011+08:00", comments="Source Table: role_resource")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.011+08:00", comments="Source Table: role_resource")
    default int insert(RoleResource record) {
        return MyBatis3Utils.insert(this::insert, record, roleResource, c ->
            c.map(id).toProperty("id")
            .map(roleId).toProperty("roleId")
            .map(resourceId).toProperty("resourceId")
            .map(status).toProperty("status")
            .map(timeCreated).toProperty("timeCreated")
            .map(timeUpdated).toProperty("timeUpdated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.011+08:00", comments="Source Table: role_resource")
    default int insertMultiple(Collection<RoleResource> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, roleResource, c ->
            c.map(id).toProperty("id")
            .map(roleId).toProperty("roleId")
            .map(resourceId).toProperty("resourceId")
            .map(status).toProperty("status")
            .map(timeCreated).toProperty("timeCreated")
            .map(timeUpdated).toProperty("timeUpdated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.011+08:00", comments="Source Table: role_resource")
    default int insertSelective(RoleResource record) {
        return MyBatis3Utils.insert(this::insert, record, roleResource, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(resourceId).toPropertyWhenPresent("resourceId", record::getResourceId)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(timeCreated).toPropertyWhenPresent("timeCreated", record::getTimeCreated)
            .map(timeUpdated).toPropertyWhenPresent("timeUpdated", record::getTimeUpdated)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.012+08:00", comments="Source Table: role_resource")
    default Optional<RoleResource> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.012+08:00", comments="Source Table: role_resource")
    default List<RoleResource> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.012+08:00", comments="Source Table: role_resource")
    default List<RoleResource> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.012+08:00", comments="Source Table: role_resource")
    default Optional<RoleResource> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.012+08:00", comments="Source Table: role_resource")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.012+08:00", comments="Source Table: role_resource")
    static UpdateDSL<UpdateModel> updateAllColumns(RoleResource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(roleId).equalTo(record::getRoleId)
                .set(resourceId).equalTo(record::getResourceId)
                .set(status).equalTo(record::getStatus)
                .set(timeCreated).equalTo(record::getTimeCreated)
                .set(timeUpdated).equalTo(record::getTimeUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.012+08:00", comments="Source Table: role_resource")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RoleResource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(resourceId).equalToWhenPresent(record::getResourceId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(timeCreated).equalToWhenPresent(record::getTimeCreated)
                .set(timeUpdated).equalToWhenPresent(record::getTimeUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.013+08:00", comments="Source Table: role_resource")
    default int updateByPrimaryKey(RoleResource record) {
        return update(c ->
            c.set(roleId).equalTo(record::getRoleId)
            .set(resourceId).equalTo(record::getResourceId)
            .set(status).equalTo(record::getStatus)
            .set(timeCreated).equalTo(record::getTimeCreated)
            .set(timeUpdated).equalTo(record::getTimeUpdated)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.013+08:00", comments="Source Table: role_resource")
    default int updateByPrimaryKeySelective(RoleResource record) {
        return update(c ->
            c.set(roleId).equalToWhenPresent(record::getRoleId)
            .set(resourceId).equalToWhenPresent(record::getResourceId)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(timeCreated).equalToWhenPresent(record::getTimeCreated)
            .set(timeUpdated).equalToWhenPresent(record::getTimeUpdated)
            .where(id, isEqualTo(record::getId))
        );
    }
}