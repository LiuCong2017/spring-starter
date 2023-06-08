package com.springstarter.e05_spring_dao.spring_dao_02.JdbcDaoSupport;

import com.springstarter.e05_spring_dao.spring_dao_02.mappingsqlquery.UserMappingSqlQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SpringDAODemo extends JdbcDaoSupport implements IUserDAO{

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDAO userDao = (IUserDAO) context.getBean("userDao");

        User user = new User(null,"JdbcDaoSupport",29,983.32);
        userDao.addUser(user);

        List<User> list = userDao.queryAllUser();
        for (User u:list){
            System.out.println(u.toString());
        }
    }

    @Override
    public List<User> queryAllUser() {
        String sql = "select * from t_user order by id desc";
        List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
        List<User> userList = new ArrayList<>();
        for (Map<String, Object> row:list){
            User user = new User();
            user.setId((Integer) row.get("id"));
            user.setName((String) row.get("name"));
            user.setAge((Integer) row.get("age"));
            user.setMoney(Double.parseDouble(row.get("money").toString()));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into t_user (name,age,money) values(?,?,?)";
        int row = getJdbcTemplate().update(sql,new Object[]{user.getName(),user.getAge(),user.getMoney()});
        if (row>0){
            return true;
        }
        return false;
    }

    //使用MappingSqlQuery
    public List<User> mappingSqlQueryAllUser() {
        String sql = "select * from t_user where ?";
        UserMappingSqlQuery query = new UserMappingSqlQuery();
        query.setDataSource(Objects.requireNonNull(getDataSource()));
        query.setSql(sql);
        query.setParameters(new SqlParameter(Types.VARCHAR));
        query.compile();
        return query.execute(new Object[]{new String("1=1")});
    }

    /** Spring事务管理 */
    @Override
    public boolean transfer(int from, int to, float money) {
        boolean out = outInMoney(from,-money);
        int i=1/0; //事务回滚
        boolean in = outInMoney(to,money);

        return out&in;
    }
    private boolean outInMoney(int to,float money){
        String sql = "update t_user set money=money+? where id=?";
        int row = getJdbcTemplate().update(sql,new Object[]{money,to});
        if (row>0) return true;
        return false;
    }

}
