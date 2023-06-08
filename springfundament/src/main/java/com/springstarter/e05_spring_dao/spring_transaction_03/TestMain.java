package com.springstarter.e05_spring_dao.spring_transaction_03;

import com.springstarter.e05_spring_dao.spring_dao_02.JdbcDaoSupport.IUserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDAO dao = (IUserDAO) context.getBean("userDaoProxy");
        try {
            dao.transfer(1,2,100);
        } catch (Exception e) {
            System.out.println("rollback transaction");
        }
    }
}
