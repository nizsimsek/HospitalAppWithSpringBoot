package com.nizdeniz.HospitalApp.DataAccess.Concrete;

import com.nizdeniz.HospitalApp.DataAccess.Abstract.IPersonalDal;
import com.nizdeniz.HospitalApp.Entities.Abstract.IEntity;
import com.nizdeniz.HospitalApp.Entities.Concrete.Personal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalDal implements IPersonalDal {

    private IEntity _personalDal;
    private Connection _connection;

    public PersonalDal(IEntity _personalDal) {
        try {
            _connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "12345");
            System.out.println("Veritabanı bağlantısı başarılı");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this._personalDal = _personalDal;
    }

    @Override
    public List<Personal> GetAll() {
        List<Personal> personals = new ArrayList<Personal>();
        try {
            PreparedStatement ps = _connection.prepareStatement("SELECT * FROM Personal");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Personal personal = new Personal();
                personal.setId(rs.getInt("Id"));
                personal.setName(rs.getString("Name"));
                personal.setSurname(rs.getString("Surname"));
                personal.setNationalId(rs.getInt("NationalId"));
                personal.setDegreeId(rs.getInt("DegreeId"));
                personal.setStatusId(rs.getInt("StatusId"));
                personal.setEmail(rs.getString("Email"));
                personal.setPhoneNumber(rs.getString("PhoneNumber"));
                personal.setGender(rs.getString("Gender"));
                personals.add(personal);
            }
            return personals;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void Add(Personal personal) {
        PreparedStatement ps = null;
        int status = 0;
        try {
            ps = _connection.prepareStatement("INSERT INTO Personal(Name, Surname, NationalId, DegreeId, " +
                    "StatusId, Email, PhoneNumber, Gender) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, personal.getName());
            ps.setString(2, personal.getSurname());
            ps.setInt(3, personal.getNationalId());
            ps.setInt(4, personal.getDegreeId());
            ps.setInt(5, personal.getStatusId());
            ps.setString(6, personal.getEmail());
            ps.setString(7, personal.getPhoneNumber());
            ps.setString(8, personal.getGender());
            status = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Update(Personal personal) {
        PreparedStatement ps = null;
        int status = 0;
        try {
            ps = _connection.prepareStatement("UPDATE Personal SET Name = ?, Surname = ?, NationalId = ?," +
                    " DegreeId = ?, StatusId = ?, Email = ?, PhoneNumber = ?, Gender = ? WHERE Id = ?");
            ps.setString(1, personal.getName());
            ps.setString(2, personal.getSurname());
            ps.setInt(3, personal.getNationalId());
            ps.setInt(4, personal.getDegreeId());
            ps.setInt(5, personal.getStatusId());
            ps.setString(6, personal.getEmail());
            ps.setString(7, personal.getPhoneNumber());
            ps.setString(8, personal.getGender());
            ps.setInt(9, personal.getId());
            status = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Delete(Personal personal) {
        PreparedStatement ps = null;
        int status = 0;
        try {
            ps = _connection.prepareStatement("DELETE FROM Personal WHERE Id=?");
            ps.setInt(1, personal.getId());

            status = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Personal GetById(int id) {
        PreparedStatement ps = null;
        int status = 0;
        try {
            ps = _connection.prepareStatement("SELECT * FROM Personal WHERE Id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Personal personal = new Personal();
            personal.setId(rs.getInt("Id"));
            personal.setName(rs.getString("Name"));
            personal.setSurname(rs.getString("Surname"));
            personal.setNationalId(rs.getInt("NationalId"));
            personal.setDegreeId(rs.getInt("DegreeId"));
            personal.setStatusId(rs.getInt("StatusId"));
            personal.setEmail(rs.getString("Email"));
            personal.setPhoneNumber(rs.getString("PhoneNumber"));
            personal.setGender(rs.getString("Gender"));
            return personal;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
