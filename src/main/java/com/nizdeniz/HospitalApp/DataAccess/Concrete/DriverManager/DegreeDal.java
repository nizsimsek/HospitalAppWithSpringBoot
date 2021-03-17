package com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager;

import com.nizdeniz.HospitalApp.Core.DataAccess.DbHelper;
import com.nizdeniz.HospitalApp.DataAccess.Abstract.IDegreeDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Degree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DegreeDal implements IDegreeDal {
    private Connection _connection;

    public DegreeDal() {
        DbHelper dbHelper = new DbHelper("jdbc:mysql://localhost:3306/hospitaldb", "root","12345");
        try {
            _connection = dbHelper.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Degree> GetAll() {
        List<Degree> degrees = new ArrayList<>();
        try {
            PreparedStatement ps = _connection.prepareStatement("SELECT * FROM degree");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Degree degree = new Degree();
                degree.setId(rs.getInt("Id"));
                degree.setName(rs.getString("Name"));
                degrees.add(degree);
            }
            return degrees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void Add(Degree degree) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("INSERT INTO Degree(Name) VALUES (?)");
            ps.setString(1, degree.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Update(Degree degree) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("UPDATE Degree SET Name = ? WHERE Id = ?");
            ps.setString(1, degree.getName());
            ps.setInt(2, degree.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Delete(Degree degree) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("DELETE FROM Degree WHERE Id = ?");
            ps.setInt(1, degree.getId());
            ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Degree GetById(int id) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("SELECT * FROM Degree WHERE Id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Degree degree = new Degree();
            degree.setId(rs.getInt("Id"));
            degree.setName(rs.getString("Name"));
            return degree;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
