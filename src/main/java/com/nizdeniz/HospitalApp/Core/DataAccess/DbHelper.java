
package com.nizdeniz.HospitalApp.Core.DataAccess;

import com.nizdeniz.HospitalApp.Core.DataAccess.DbHelpers.MySQLHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    public Connection connection = null;
    MySQLHelper _mySQLHelper = new MySQLHelper();

    public Connection getConnection() throws SQLException {
        return connection = DriverManager.getConnection(_mySQLHelper.getConnectionString(), _mySQLHelper.getUserName(),_mySQLHelper.getPassword());
    }
}