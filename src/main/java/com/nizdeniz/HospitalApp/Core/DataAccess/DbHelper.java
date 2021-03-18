package com.nizdeniz.HospitalApp.Core.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    public Connection connection = null;

    public Connection getConnection() throws SQLException {
        String password = "12345";
        String connectionString = "jdbc:mysql://localhost:3306/hospitaldb";
        String userName = "root";
        return connection = DriverManager.getConnection(connectionString, userName, password);
    }
}