package com.nizdeniz.HospitalApp.DataAccess.Concrete;

import com.nizdeniz.HospitalApp.DataAccess.Abstract.IDegreeDal;
import com.nizdeniz.HospitalApp.Entities.Abstract.IEntity;
import com.nizdeniz.HospitalApp.Entities.Concrete.Degree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DegreeDal implements IDegreeDal {
    private final IEntity _degreeDal;
    private Connection _connection;

    public DegreeDal(IEntity _degreeDal) {
        try {
            _connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb");
            System.out.println("Veritabanı bağlantısı başarılı");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this._degreeDal = _degreeDal;
    }

    @Override
    public List<Degree> GetAll() {
        List<Degree> degrees = new ArrayList<>();
        try {
            PreparedStatement ps = _connection.prepareStatement("SELECT * FROM Degree");
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
