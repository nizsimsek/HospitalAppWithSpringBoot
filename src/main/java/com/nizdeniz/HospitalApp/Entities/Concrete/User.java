package com.nizdeniz.HospitalApp.Entities.Concrete;

import com.nizdeniz.HospitalApp.Core.Entities.IEntity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User implements IEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "Email")
    private String Email;

    @Column(name = "PasswordHash")
    private String PasswordHash;

    @Column(name = "PasswordSalt")
    private String PasswordSalt;

    @Column(name = "RoleId")
    private int RoleId;

    public User() {

    }

    public User(int id, String email, String passwordHash, String passwordSalt, int roleId) {
        Id = id;
        Email = email;
        PasswordHash = passwordHash;
        PasswordSalt = passwordSalt;
        RoleId = roleId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return PasswordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        PasswordSalt = passwordSalt;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }
}
