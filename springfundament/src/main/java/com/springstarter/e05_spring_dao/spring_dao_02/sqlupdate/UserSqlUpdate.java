package com.springstarter.e05_spring_dao.spring_dao_02.sqlupdate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class UserSqlUpdate extends SqlUpdate {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserSqlUpdate userSqlUpdate = (UserSqlUpdate) context.getBean("userSqlUpdate");
        userSqlUpdate.updateUserMoney("Cody",666.66);
    }

    public UserSqlUpdate(DataSource ds){
        setDataSource(ds);
        setSql("update  t_user set money=? where name=?");
        declareParameter(new SqlParameter(Types.DOUBLE));
        declareParameter(new SqlParameter(Types.VARCHAR));
        compile();
    }

    public boolean updateUserMoney(String name,double money){
        int row = update(new Object[]{money,name});
        if (row>0){
            return true;
        }
        return false;
    }

}
