package com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager;

import com.nizdeniz.HospitalApp.Core.DataAccess.DbHelper;
import com.nizdeniz.HospitalApp.Core.DataAccess.IEntityBaseRepository;
import com.nizdeniz.HospitalApp.Entities.Concrete.EmployeeStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeStatusDal implements IEntityBaseRepository<EmployeeStatus> {
    private Connection _connection;

    public EmployeeStatusDal() {
        DbHelper dbHelper = new DbHelper();
        try {
            _connection = dbHelper.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public List<EmployeeStatus> GetAll() {
        List<EmployeeStatus> employeeStatuses = new ArrayList<>();
        try {
            PreparedStatement ps = _connection.prepareStatement("SELECT * FROM Employee_Status");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmployeeStatus employeeStatus = new EmployeeStatus();
                employeeStatus.setId(rs.getInt("Id"));
                employeeStatus.setName(rs.getString("Name"));
                employeeStatuses.add(employeeStatus);
            }
            return employeeStatuses;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void Add(EmployeeStatus entity) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("INSERT INTO Employee_Status(Name) VALUES (?)");
            ps.setString(1, entity.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Update(EmployeeStatus entity) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("UPDATE Employee_Status SET Name = ? WHERE Id = ?");
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void DeleteById(int id) {

    }

    @Override
    public EmployeeStatus GetById(int id) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("SELECT * FROM Employee_Status WHERE Id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            EmployeeStatus employeeStatus = new EmployeeStatus();
            employeeStatus.setId(rs.getInt("Id"));
            employeeStatus.setName(rs.getString("Name"));
            return employeeStatus;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
