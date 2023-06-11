package com.springstarter.f06_mybatis;

import com.springstarter.e05_spring_dao.spring_dao_02.JdbcDaoSupport.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BasicDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        String statement = "com.springstarter.f06_mybatis.UserMapper.getUserList";
        List<User> users = session.selectList(statement);
        for (User u:users){
            System.out.println(u.toString());
        }

    }
}
