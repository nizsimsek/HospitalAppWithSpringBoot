package com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager;

import com.nizdeniz.HospitalApp.Core.DataAccess.DbHelper;
import com.nizdeniz.HospitalApp.DataAccess.Abstract.IUserDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDal implements IUserDal {
    private Connection _connection;

    public UserDal() {
        DbHelper dbHelper = new DbHelper("jdbc:mysql://localhost:3306/hospitaldb", "root", "12345");
        try {
            _connection = dbHelper.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<User> GetAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = _connection.prepareStatement("SELECT * FROM User");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("Id"));
                user.setEmail(rs.getString("Email"));
                user.setPasswordHash(rs.getString("PasswordHash"));
                user.setPasswordSalt(rs.getString("PasswordSalt"));
                user.setRoleId(rs.getInt("RoleId"));
                users.add(user);
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void Add(User user) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("INSERT INTO User(Email, PasswordHash, PasswordSalt, RoleId) VALUES(?, ?, ?, ?)");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPasswordHash());
            ps.setString(3, user.getPasswordSalt());
            ps.setInt(4, user.getRoleId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Update(User user) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("UPDATE User SET Email = ?, PasswordHash = ?, PasswordSalt = ?, RoleId = ? WHERE Id = ?");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPasswordHash());
            ps.setString(3, user.getPasswordSalt());
            ps.setInt(4, user.getRoleId());
            ps.setInt(5, user.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void Delete(User user) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("DELETE FROM User WHERE Id = ?");
            ps.setInt(1, user.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User GetById(int id) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("SELECT * FROM User WHERE Id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            user.setId(rs.getInt("Id"));
            user.setEmail(rs.getString("Email"));
            user.setPasswordHash(rs.getString("PasswordHash"));
            user.setPasswordSalt(rs.getString("PasswordSalt"));
            user.setRoleId(rs.getInt("RoleId"));
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
