package com.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionConf {


    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.33.10/ProjectX", "root", "admin123");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/projectx", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}

