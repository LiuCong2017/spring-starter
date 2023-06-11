package com.springstarter.f06_mybatis;

import com.springstarter.e05_spring_dao.spring_dao_02.JdbcDaoSupport.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> getUserList();
    void addUser(User user);
    User getUser(@Param("id") int id);
}
