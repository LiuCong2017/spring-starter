package com.springstarter.e05_spring_dao.jdbc_01;

import java.sql.*;

public class JdbcTransaction {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daodemodb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","root");

            connection.setAutoCommit(false); //手动开启事务
            String sql = "update t_user set money=money-? where id=?";
            ptmt =  connection.prepareStatement(sql);

            ptmt.setDouble(1,121.11);
            ptmt.setInt(2,2);
            ptmt.addBatch();

            ptmt.setDouble(1,-121.11);
            ptmt.setInt(2,1);
            ptmt.addBatch();

            ptmt.executeBatch();

            connection.commit();//提交事务

        } catch (SQLException e) {
            connection.rollback(); //事务回滚
            e.printStackTrace();
        } finally {
            if (connection!=null) connection.close();
            if (ptmt!=null) ptmt.close();
            if (rs!=null) rs.close();
        }

    }

}
