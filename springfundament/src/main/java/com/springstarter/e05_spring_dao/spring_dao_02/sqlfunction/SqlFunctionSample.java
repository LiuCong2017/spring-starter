package com.springstarter.e05_spring_dao.spring_dao_02.sqlfunction;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.SqlFunction;

public class SqlFunctionSample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BasicDataSource ds = (BasicDataSource) context.getBean("datasource");
        SqlFunction sf = new SqlFunction<>(ds,"select count(1) from t_user;");
        sf.compile();
        int count = sf.run();
    }

}
