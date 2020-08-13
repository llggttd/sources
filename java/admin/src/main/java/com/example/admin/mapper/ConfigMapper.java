package com.example.admin.mapper;

import static com.example.admin.mapper.ConfigDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.example.admin.model.Config;
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
public interface ConfigMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.975+08:00", comments="Source Table: config")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, value, type, enable, timeCreated, timeUpdated);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.952+08:00", comments="Source Table: config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.953+08:00", comments="Source Table: config")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.954+08:00", comments="Source Table: config")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Config> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.955+08:00", comments="Source Table: config")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Config> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.957+08:00", comments="Source Table: config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ConfigResult")
    Optional<Config> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.958+08:00", comments="Source Table: config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ConfigResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable", property="enable", jdbcType=JdbcType.INTEGER),
        @Result(column="time_created", property="timeCreated", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_updated", property="timeUpdated", jdbcType=JdbcType.VARCHAR)
    })
    List<Config> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.961+08:00", comments="Source Table: config")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.962+08:00", comments="Source Table: config")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, config, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.963+08:00", comments="Source Table: config")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, config, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.964+08:00", comments="Source Table: config")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.964+08:00", comments="Source Table: config")
    default int insert(Config record) {
        return MyBatis3Utils.insert(this::insert, record, config, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(value).toProperty("value")
            .map(type).toProperty("type")
            .map(enable).toProperty("enable")
            .map(timeCreated).toProperty("timeCreated")
            .map(timeUpdated).toProperty("timeUpdated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.968+08:00", comments="Source Table: config")
    default int insertMultiple(Collection<Config> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, config, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(value).toProperty("value")
            .map(type).toProperty("type")
            .map(enable).toProperty("enable")
            .map(timeCreated).toProperty("timeCreated")
            .map(timeUpdated).toProperty("timeUpdated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.969+08:00", comments="Source Table: config")
    default int insertSelective(Config record) {
        return MyBatis3Utils.insert(this::insert, record, config, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(value).toPropertyWhenPresent("value", record::getValue)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(enable).toPropertyWhenPresent("enable", record::getEnable)
            .map(timeCreated).toPropertyWhenPresent("timeCreated", record::getTimeCreated)
            .map(timeUpdated).toPropertyWhenPresent("timeUpdated", record::getTimeUpdated)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.977+08:00", comments="Source Table: config")
    default Optional<Config> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, config, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.978+08:00", comments="Source Table: config")
    default List<Config> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, config, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.979+08:00", comments="Source Table: config")
    default List<Config> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, config, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.98+08:00", comments="Source Table: config")
    default Optional<Config> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.981+08:00", comments="Source Table: config")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, config, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.982+08:00", comments="Source Table: config")
    static UpdateDSL<UpdateModel> updateAllColumns(Config record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(value).equalTo(record::getValue)
                .set(type).equalTo(record::getType)
                .set(enable).equalTo(record::getEnable)
                .set(timeCreated).equalTo(record::getTimeCreated)
                .set(timeUpdated).equalTo(record::getTimeUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.983+08:00", comments="Source Table: config")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Config record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(value).equalToWhenPresent(record::getValue)
                .set(type).equalToWhenPresent(record::getType)
                .set(enable).equalToWhenPresent(record::getEnable)
                .set(timeCreated).equalToWhenPresent(record::getTimeCreated)
                .set(timeUpdated).equalToWhenPresent(record::getTimeUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.984+08:00", comments="Source Table: config")
    default int updateByPrimaryKey(Config record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(value).equalTo(record::getValue)
            .set(type).equalTo(record::getType)
            .set(enable).equalTo(record::getEnable)
            .set(timeCreated).equalTo(record::getTimeCreated)
            .set(timeUpdated).equalTo(record::getTimeUpdated)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-13T12:16:14.986+08:00", comments="Source Table: config")
    default int updateByPrimaryKeySelective(Config record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(value).equalToWhenPresent(record::getValue)
            .set(type).equalToWhenPresent(record::getType)
            .set(enable).equalToWhenPresent(record::getEnable)
            .set(timeCreated).equalToWhenPresent(record::getTimeCreated)
            .set(timeUpdated).equalToWhenPresent(record::getTimeUpdated)
            .where(id, isEqualTo(record::getId))
        );
    }
}