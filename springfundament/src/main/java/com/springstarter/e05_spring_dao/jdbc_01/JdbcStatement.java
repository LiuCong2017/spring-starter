package com.springstarter.e05_spring_dao.jdbc_01;

import java.sql.*;

public class JdbcStatement {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //or
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daodemodb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","root");
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from t_user");
            while (rs.next()){
                System.out.print("name:"+rs.getString("name"));
                System.out.print(" - age:"+rs.getString("age"));
                System.out.print(" - money:"+rs.getString("money"));
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection!=null) connection.close();
            if (stmt!=null) stmt.close();
            if (rs!=null) rs.close();
        }


    }

}
