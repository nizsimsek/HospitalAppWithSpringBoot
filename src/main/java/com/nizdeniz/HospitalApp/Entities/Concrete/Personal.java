package com.nizdeniz.HospitalApp.Entities.Concrete;

import com.nizdeniz.HospitalApp.Core.Entities.IEntity;

public class Personal implements IEntity {
    private int Id;
    private String Name;
    private String Surname;
    private String NationalId;
    private int DegreeId;
    private int StatusId;
    private String Email;
    private String PhoneNumber;
    private String Gender;

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
