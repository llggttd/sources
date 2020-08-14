package com.example.admin.mapper;

import static com.example.admin.mapper.ResourceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.example.admin.model.Resource;
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
import org.springframework.stereotype.Component;

@Mapper
public interface ResourceMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.996+08:00", comments="Source Table: resource")
    BasicColumn[] selectList = BasicColumn.columnList(id, resourceName, resourceType, resourceOrder, resourceIcon, resourceSign, resourceUri, parentId, status, timeCreated, timeUpdated);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.995+08:00", comments="Source Table: resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.995+08:00", comments="Source Table: resource")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.995+08:00", comments="Source Table: resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Resource> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.995+08:00", comments="Source Table: resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Resource> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.995+08:00", comments="Source Table: resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ResourceResult")
    Optional<Resource> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.995+08:00", comments="Source Table: resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ResourceResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="resource_name", property="resourceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_type", property="resourceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_order", property="resourceOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_icon", property="resourceIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_sign", property="resourceSign", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_uri", property="resourceUri", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="time_created", property="timeCreated", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_updated", property="timeUpdated", jdbcType=JdbcType.VARCHAR)
    })
    List<Resource> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.995+08:00", comments="Source Table: resource")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.996+08:00", comments="Source Table: resource")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.996+08:00", comments="Source Table: resource")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.996+08:00", comments="Source Table: resource")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.996+08:00", comments="Source Table: resource")
    default int insert(Resource record) {
        return MyBatis3Utils.insert(this::insert, record, resource, c ->
            c.map(id).toProperty("id")
            .map(resourceName).toProperty("resourceName")
            .map(resourceType).toProperty("resourceType")
            .map(resourceOrder).toProperty("resourceOrder")
            .map(resourceIcon).toProperty("resourceIcon")
            .map(resourceSign).toProperty("resourceSign")
            .map(resourceUri).toProperty("resourceUri")
            .map(parentId).toProperty("parentId")
            .map(status).toProperty("status")
            .map(timeCreated).toProperty("timeCreated")
            .map(timeUpdated).toProperty("timeUpdated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.996+08:00", comments="Source Table: resource")
    default int insertMultiple(Collection<Resource> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, resource, c ->
            c.map(id).toProperty("id")
            .map(resourceName).toProperty("resourceName")
            .map(resourceType).toProperty("resourceType")
            .map(resourceOrder).toProperty("resourceOrder")
            .map(resourceIcon).toProperty("resourceIcon")
            .map(resourceSign).toProperty("resourceSign")
            .map(resourceUri).toProperty("resourceUri")
            .map(parentId).toProperty("parentId")
            .map(status).toProperty("status")
            .map(timeCreated).toProperty("timeCreated")
            .map(timeUpdated).toProperty("timeUpdated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.996+08:00", comments="Source Table: resource")
    default int insertSelective(Resource record) {
        return MyBatis3Utils.insert(this::insert, record, resource, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(resourceName).toPropertyWhenPresent("resourceName", record::getResourceName)
            .map(resourceType).toPropertyWhenPresent("resourceType", record::getResourceType)
            .map(resourceOrder).toPropertyWhenPresent("resourceOrder", record::getResourceOrder)
            .map(resourceIcon).toPropertyWhenPresent("resourceIcon", record::getResourceIcon)
            .map(resourceSign).toPropertyWhenPresent("resourceSign", record::getResourceSign)
            .map(resourceUri).toPropertyWhenPresent("resourceUri", record::getResourceUri)
            .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(timeCreated).toPropertyWhenPresent("timeCreated", record::getTimeCreated)
            .map(timeUpdated).toPropertyWhenPresent("timeUpdated", record::getTimeUpdated)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.997+08:00", comments="Source Table: resource")
    default Optional<Resource> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.997+08:00", comments="Source Table: resource")
    default List<Resource> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.997+08:00", comments="Source Table: resource")
    default List<Resource> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.997+08:00", comments="Source Table: resource")
    default Optional<Resource> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.997+08:00", comments="Source Table: resource")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.997+08:00", comments="Source Table: resource")
    static UpdateDSL<UpdateModel> updateAllColumns(Resource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(resourceName).equalTo(record::getResourceName)
                .set(resourceType).equalTo(record::getResourceType)
                .set(resourceOrder).equalTo(record::getResourceOrder)
                .set(resourceIcon).equalTo(record::getResourceIcon)
                .set(resourceSign).equalTo(record::getResourceSign)
                .set(resourceUri).equalTo(record::getResourceUri)
                .set(parentId).equalTo(record::getParentId)
                .set(status).equalTo(record::getStatus)
                .set(timeCreated).equalTo(record::getTimeCreated)
                .set(timeUpdated).equalTo(record::getTimeUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.997+08:00", comments="Source Table: resource")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Resource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(resourceName).equalToWhenPresent(record::getResourceName)
                .set(resourceType).equalToWhenPresent(record::getResourceType)
                .set(resourceOrder).equalToWhenPresent(record::getResourceOrder)
                .set(resourceIcon).equalToWhenPresent(record::getResourceIcon)
                .set(resourceSign).equalToWhenPresent(record::getResourceSign)
                .set(resourceUri).equalToWhenPresent(record::getResourceUri)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(timeCreated).equalToWhenPresent(record::getTimeCreated)
                .set(timeUpdated).equalToWhenPresent(record::getTimeUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.997+08:00", comments="Source Table: resource")
    default int updateByPrimaryKey(Resource record) {
        return update(c ->
            c.set(resourceName).equalTo(record::getResourceName)
            .set(resourceType).equalTo(record::getResourceType)
            .set(resourceOrder).equalTo(record::getResourceOrder)
            .set(resourceIcon).equalTo(record::getResourceIcon)
            .set(resourceSign).equalTo(record::getResourceSign)
            .set(resourceUri).equalTo(record::getResourceUri)
            .set(parentId).equalTo(record::getParentId)
            .set(status).equalTo(record::getStatus)
            .set(timeCreated).equalTo(record::getTimeCreated)
            .set(timeUpdated).equalTo(record::getTimeUpdated)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.998+08:00", comments="Source Table: resource")
    default int updateByPrimaryKeySelective(Resource record) {
        return update(c ->
            c.set(resourceName).equalToWhenPresent(record::getResourceName)
            .set(resourceType).equalToWhenPresent(record::getResourceType)
            .set(resourceOrder).equalToWhenPresent(record::getResourceOrder)
            .set(resourceIcon).equalToWhenPresent(record::getResourceIcon)
            .set(resourceSign).equalToWhenPresent(record::getResourceSign)
            .set(resourceUri).equalToWhenPresent(record::getResourceUri)
            .set(parentId).equalToWhenPresent(record::getParentId)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(timeCreated).equalToWhenPresent(record::getTimeCreated)
            .set(timeUpdated).equalToWhenPresent(record::getTimeUpdated)
            .where(id, isEqualTo(record::getId))
        );
    }
}