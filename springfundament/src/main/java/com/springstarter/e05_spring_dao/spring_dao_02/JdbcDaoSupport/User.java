package com.springstarter.e05_spring_dao.spring_dao_02.JdbcDaoSupport;

import com.springstarter.f06_mybatis.typehandlers.UserState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Double money;
    private UserState status;
}
