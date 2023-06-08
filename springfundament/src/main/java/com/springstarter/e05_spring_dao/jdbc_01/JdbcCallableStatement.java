package com.springstarter.e05_spring_dao.jdbc_01;

import java.sql.*;

/** 调用存储过程 */
public class JdbcCallableStatement {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        CallableStatement ctmt = null;
        ResultSet rs = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daodemodb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","root");
            ctmt = connection.prepareCall("{call p_selectUserByAge(?,?)}");
            ctmt.setInt(1,24);
            ctmt.registerOutParameter(2, Types.INTEGER);
            rs = ctmt.executeQuery();
            while (rs.next()){
                System.out.print("name:"+rs.getString("name"));
                System.out.print(" - age:"+rs.getString("age"));
                System.out.print(" - money:"+rs.getString("money"));
                System.out.println();
            }
            System.out.println("Procedure return value: "+ctmt.getInt(2));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection!=null) connection.close();
            if (ctmt!=null) ctmt.close();
            if (rs!=null) rs.close();
        }

    }

}
