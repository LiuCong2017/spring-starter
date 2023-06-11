package com.springstarter.f06_mybatis.typehandlers;

import com.springstarter.e05_spring_dao.spring_dao_02.JdbcDaoSupport.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class TestMain {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        String statement1 = "com.springstarter.f06_mybatis.UserMapper.addUser";
        User user = new User(null,"usermode",22,5444.98,UserState.AVAILABLE);
//        User user = new User(null,"usermode",22,5444.98,UserState.AVAILABLE.getStatus());
        session.insert(statement1,user);
        session.commit();

        System.out.println(user.getId());
        String statement2 = "com.springstarter.f06_mybatis.UserMapper.getUser";
        user = session.selectOne(statement2,user.getId());
        System.out.println(user.toString());

    }

}
