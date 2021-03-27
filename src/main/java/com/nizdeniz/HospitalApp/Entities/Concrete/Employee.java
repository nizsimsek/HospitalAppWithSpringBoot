package com.nizdeniz.HospitalApp.Entities.Concrete;

import com.nizdeniz.HospitalApp.Core.Entities.IEntity;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Surname")
    private String Surname;

    @Column(name = "NationalId")
    private String NationalId;

    @Column(name = "DegreeId")
    private int DegreeId;

    @Column(name = "StatusId")
    private int StatusId;

    @Column(name = "Email")
    private String Email;

    @Column(name = "PhoneNumber")
    private String PhoneNumber;

    @Column(name = "Gender")
    private String Gender;

    public Employee() {
    }

    public Employee(int id, String name, String surname, String nationalId, int degreeId, int statusId, String email, String phoneNumber, String gender) {
        Id = id;
        Name = name;
        Surname = surname;
        NationalId = nationalId;
        DegreeId = degreeId;
        StatusId = statusId;
        Email = email;
        PhoneNumber = phoneNumber;
        Gender = gender;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getNationalId() {
        return NationalId;
    }

    public void setNationalId(String nationalId) {
        NationalId = nationalId;
    }

    public int getDegreeId() {
        return DegreeId;
    }

    public void setDegreeId(int degreeId) {
        DegreeId = degreeId;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}