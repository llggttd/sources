package com.example.admin.mapper;

import static com.example.admin.mapper.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.example.admin.model.User;
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
@Component
public interface UserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.017+08:00", comments="Source Table: user")
    BasicColumn[] selectList = BasicColumn.columnList(id, username, password, mobile, status, timeCreated, timeUpdated);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source Table: user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source Table: user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.015+08:00", comments="Source Table: user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<User> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.016+08:00", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.016+08:00", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="time_created", property="timeCreated", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_updated", property="timeUpdated", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.016+08:00", comments="Source Table: user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.016+08:00", comments="Source Table: user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.016+08:00", comments="Source Table: user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.016+08:00", comments="Source Table: user")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.016+08:00", comments="Source Table: user")
    default int insert(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(id).toProperty("id")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(mobile).toProperty("mobile")
            .map(status).toProperty("status")
            .map(timeCreated).toProperty("timeCreated")
            .map(timeUpdated).toProperty("timeUpdated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.016+08:00", comments="Source Table: user")
    default int insertMultiple(Collection<User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, user, c ->
            c.map(id).toProperty("id")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(mobile).toProperty("mobile")
            .map(status).toProperty("status")
            .map(timeCreated).toProperty("timeCreated")
            .map(timeUpdated).toProperty("timeUpdated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.017+08:00", comments="Source Table: user")
    default int insertSelective(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(mobile).toPropertyWhenPresent("mobile", record::getMobile)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(timeCreated).toPropertyWhenPresent("timeCreated", record::getTimeCreated)
            .map(timeUpdated).toPropertyWhenPresent("timeUpdated", record::getTimeUpdated)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.017+08:00", comments="Source Table: user")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.017+08:00", comments="Source Table: user")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.017+08:00", comments="Source Table: user")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.017+08:00", comments="Source Table: user")
    default Optional<User> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.017+08:00", comments="Source Table: user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.017+08:00", comments="Source Table: user")
    static UpdateDSL<UpdateModel> updateAllColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(mobile).equalTo(record::getMobile)
                .set(status).equalTo(record::getStatus)
                .set(timeCreated).equalTo(record::getTimeCreated)
                .set(timeUpdated).equalTo(record::getTimeUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.018+08:00", comments="Source Table: user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(mobile).equalToWhenPresent(record::getMobile)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(timeCreated).equalToWhenPresent(record::getTimeCreated)
                .set(timeUpdated).equalToWhenPresent(record::getTimeUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.018+08:00", comments="Source Table: user")
    default int updateByPrimaryKey(User record) {
        return update(c ->
            c.set(username).equalTo(record::getUsername)
            .set(password).equalTo(record::getPassword)
            .set(mobile).equalTo(record::getMobile)
            .set(status).equalTo(record::getStatus)
            .set(timeCreated).equalTo(record::getTimeCreated)
            .set(timeUpdated).equalTo(record::getTimeUpdated)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:15.018+08:00", comments="Source Table: user")
    default int updateByPrimaryKeySelective(User record) {
        return update(c ->
            c.set(username).equalToWhenPresent(record::getUsername)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(mobile).equalToWhenPresent(record::getMobile)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(timeCreated).equalToWhenPresent(record::getTimeCreated)
            .set(timeUpdated).equalToWhenPresent(record::getTimeUpdated)
            .where(id, isEqualTo(record::getId))
        );
    }
}