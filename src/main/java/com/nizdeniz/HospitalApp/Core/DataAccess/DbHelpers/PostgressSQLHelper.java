package com.nizdeniz.HospitalApp.Core.DataAccess.DbHelpers;

public class PostgressSQLHelper {
    private String ConnectionString = "jdbc:postgresql://localhost:5432/hospitaldb";
    private String UserName = "root";
    private String Password = "12345";

    public String getConnectionString() {
        return ConnectionString;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }
}
