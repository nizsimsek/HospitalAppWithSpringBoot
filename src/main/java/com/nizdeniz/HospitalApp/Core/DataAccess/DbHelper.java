package com.nizdeniz.HospitalApp.Core.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    public Connection connection = null;
    public String ConnectionString;
    public String UserName;
    public String password;

    public DbHelper(String connectionString) {
        this.ConnectionString = connectionString;
    }

    public DbHelper(String connectionString, String UserName) {
        this(connectionString);
        this.UserName = UserName;
    }

    public DbHelper(String connectionString, String userName, String password) {
        this(connectionString, userName);
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return connection = DriverManager.getConnection(ConnectionString,UserName,password);
    }
}
