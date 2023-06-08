package com.springstarter.e05_spring_dao.spring_dao_02.mappingsqlquery;

import com.springstarter.e05_spring_dao.spring_dao_02.JdbcDaoSupport.User;
import org.springframework.jdbc.object.MappingSqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMappingSqlQuery extends MappingSqlQuery<User> {

    @Override
    protected User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setMoney(rs.getDouble("money"));
        return user;
    }
}
