package com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager;

import com.nizdeniz.HospitalApp.Core.DataAccess.DbHelper;
import com.nizdeniz.HospitalApp.DataAccess.Abstract.IEmployeeDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDal implements IEmployeeDal {
    private Connection _connection;

    public EmployeeDal() {
        DbHelper dbHelper = new DbHelper();
        try {
            _connection = dbHelper.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Employee> GetAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement ps = _connection.prepareStatement("SELECT * FROM Employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("Id"));
                employee.setName(rs.getString("Name"));
                employee.setSurname(rs.getString("Surname"));
                employee.setNationalId(rs.getString("NationalId"));
                employee.setDegreeId(rs.getInt("DegreeId"));
                employee.setStatusId(rs.getInt("StatusId"));
                employee.setEmail(rs.getString("Email"));
                employee.setPhoneNumber(rs.getString("PhoneNumber"));
                employee.setGender(rs.getString("Gender"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void Add(Employee employee) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("INSERT INTO Employee(Name, Surname, NationalId, DegreeId, " +
                    "StatusId, Email, PhoneNumber, Gender) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getNationalId());
            ps.setInt(4, employee.getDegreeId());
            ps.setInt(5, employee.getStatusId());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getPhoneNumber());
            ps.setString(8, employee.getGender());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Update(Employee employee) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("UPDATE Employee SET Name = ?, Surname = ?, NationalId = ?," +
                    " DegreeId = ?, StatusId = ?, Email = ?, PhoneNumber = ?, Gender = ? WHERE Id = ?");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getNationalId());
            ps.setInt(4, employee.getDegreeId());
            ps.setInt(5, employee.getStatusId());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getPhoneNumber());
            ps.setString(8, employee.getGender());
            ps.setInt(9, employee.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void DeleteById(int id) {

    }

    @Override
    public Employee GetById(int id) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("SELECT * FROM Employee WHERE Id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Employee employee = new Employee();
            employee.setId(rs.getInt("Id"));
            employee.setName(rs.getString("Name"));
            employee.setSurname(rs.getString("Surname"));
            employee.setNationalId(rs.getString("NationalId"));
            employee.setDegreeId(rs.getInt("DegreeId"));
            employee.setStatusId(rs.getInt("StatusId"));
            employee.setEmail(rs.getString("Email"));
            employee.setPhoneNumber(rs.getString("PhoneNumber"));
            employee.setGender(rs.getString("Gender"));
            return employee;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
