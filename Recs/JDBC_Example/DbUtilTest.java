package com.test;

import com.util.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtilTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DbUtil.getConnection();
            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtil.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
