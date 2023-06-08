package com.springstarter.e05_spring_dao.spring_dao_02.JdbcDaoSupport;

import java.util.List;

public interface IUserDAO {

    List<User> queryAllUser();
    boolean addUser(User user);

    boolean transfer(int from, int to, float money);

}
