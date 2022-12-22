package com.dlnu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&serverTimezone=UTC";
            String name = "root";
            String pwd = "123456";
            con = DriverManager.getConnection(url,name,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
