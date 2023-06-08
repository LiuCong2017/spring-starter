package com.springstarter.e05_spring_dao.jdbc_01.batch_process;

import java.sql.*;

public class PreparedStatementBatch {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daodemodb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","root");

            String sql = "insert into t_user (name,age,money) values (?,?,?)";
            ptmt =connection.prepareStatement(sql);
            for (int i=0;i<2;i++){
                ptmt.setString(1,"Ptmt"+i);
                ptmt.setInt(2,25+i);
                ptmt.setDouble(3,8003.45);
                ptmt.addBatch();
            }

            int[] result = ptmt.executeBatch();
            for (int i=0;i<result.length;i++){
                System.out.println(result[i]+" ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection!=null) connection.close();
            if (ptmt!=null) ptmt.close();
            if (rs!=null) rs.close();
        }

    }

}
