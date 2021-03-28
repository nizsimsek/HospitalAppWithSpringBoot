package com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager;

import com.nizdeniz.HospitalApp.Core.DataAccess.DbHelper;
import com.nizdeniz.HospitalApp.DataAccess.Abstract.IFieldDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Field;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FieldDal implements IFieldDal {
    private Connection _connection;

    public FieldDal() {
        DbHelper dbHelper = new DbHelper();
        try {
            _connection = dbHelper.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Field> GetAll() {
        List<Field> fields = new ArrayList<>();
        try {
            PreparedStatement ps = _connection.prepareStatement("SELECT * FROM Field");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Field field = new Field();
                field.setId(rs.getInt("Id"));
                field.setName(rs.getString("Name"));
                fields.add(field);
            }
            return fields;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void Add(Field entity) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("INSERT INTO Field(Name) VALUES (?)");
            ps.setString(1, entity.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Update(Field entity) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("UPDATE Field SET Name = ? WHERE Id = ?");
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
    public Field GetById(int id) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("SELECT * FROM Field WHERE Id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Field field = new Field();
            field.setId(rs.getInt("Id"));
            field.setName(rs.getString("Name"));
            return field;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
