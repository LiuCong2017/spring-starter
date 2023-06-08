package com.springstarter.e05_spring_dao.jdbc_01;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;


public class JdbcPreparedStatement {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daodemodb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","root");

            String sql = "insert into t_user (name,age,money) values (?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,"Kavin");
            pstmt.setInt(2,29);
            pstmt.setDouble(3,1000);
            int result = pstmt.executeUpdate();
            if (result>0){
                rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    System.out.println("ID: "+rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null) conn.close();
            if (pstmt!=null) pstmt.close();
            if (rs!=null) rs.close();
        }

    }

}
