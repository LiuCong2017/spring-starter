package com.springstarter.f06_mybatis.typehandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 自定义类型处理器 */
public class CusEnumStatusHandler extends BaseTypeHandler<UserState> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UserState parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getStatus());
    }

    @Override
    public UserState getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return UserState.fromValue(rs.getInt(columnName));
    }

    @Override
    public UserState getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return UserState.fromValue(rs.getInt(columnIndex));
    }

    @Override
    public UserState getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return UserState.fromValue(cs.getInt(columnIndex));
    }
}
