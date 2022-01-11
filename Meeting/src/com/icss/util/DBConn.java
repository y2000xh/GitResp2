package com.icss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static String url = "jdbc:mysql://localhost:3306/meeting?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    private static String username = "root";
    private static String password = "123456";

    /*
     * 加载驱动
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * 创建连接
     * */
    public static Connection getCon() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

}
