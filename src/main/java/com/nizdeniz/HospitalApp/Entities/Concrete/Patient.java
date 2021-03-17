package com.nizdeniz.HospitalApp.Entities.Concrete;

import com.nizdeniz.HospitalApp.Entities.Abstract.IEntity;

import java.sql.Date;

public class Patient implements IEntity {
    private int Id;
    private String Name;
    private String Surname;
    private String NationalId;
    private int FieldId;
    private String PhoneNumber;
    private Date CreatedDate;
    private String Email;

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

    public int getFieldId() {
        return FieldId;
    }

    public void setFieldId(int fieldId) {
        FieldId = fieldId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
