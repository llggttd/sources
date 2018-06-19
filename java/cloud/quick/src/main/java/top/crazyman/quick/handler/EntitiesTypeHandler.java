package top.crazyman.quick.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import top.crazyman.quick.enums.EntitiesTypeEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/5/29
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class EntitiesTypeHandler extends BaseTypeHandler<EntitiesTypeEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EntitiesTypeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public EntitiesTypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        return s == null ? null : EntitiesTypeEnum.valueOf(s);
    }

    @Override
    public EntitiesTypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String s = rs.getString(columnIndex);
        return s == null ? null : EntitiesTypeEnum.valueOf(s);
    }

    @Override
    public EntitiesTypeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String s = cs.getString(columnIndex);
        return s == null ? null : EntitiesTypeEnum.valueOf(s);
    }
}
