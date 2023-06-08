package com.springstarter.e05_spring_dao.jdbc_01.batch_process;

import java.sql.*;

public class StatementBatch {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daodemodb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","root");

            stmt = connection.createStatement();
            for (int i=0;i<2;i++){
                String sql = "insert into t_user (name,age,money) values ('StatementTest"+i+"',"+25+i+",222.22)";
                stmt.addBatch(sql);
            }

            int[] result = stmt.executeBatch();
            for (int i=0;i<result.length;i++){
                System.out.println(result[i]+" ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection!=null) connection.close();
            if (stmt!=null) stmt.close();
            if (rs!=null) rs.close();
        }

    }

}
