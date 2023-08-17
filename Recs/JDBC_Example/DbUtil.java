package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static String jdbcName;  //driver message
    private static String dbUrl;    //url
    private static String dbUsername;   //user msg
    private static String dbPassword;   //psword msg

    static {
        jdbcName = "com.mysql.jdbc.Driver";
        dbUrl = "jdbc:mysql://localhost:3306/db_web";
        dbUsername = "****";
        dbPassword = "*********";
        try {
            Class.forName(jdbcName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        return con;
    }

    public static void closeConnection(Connection con) throws SQLException {
        if (null != con){
            con.close();
        }
    }
}
