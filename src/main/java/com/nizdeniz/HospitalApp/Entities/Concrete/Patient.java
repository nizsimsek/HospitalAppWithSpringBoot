package com.nizdeniz.HospitalApp.Entities.Concrete;

import com.nizdeniz.HospitalApp.Core.Entities.IEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Patient")
public class Patient implements IEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="Name")
    private String Name;

    @Column(name="Surname")
    private String Surname;

    @Column(name="NationalId")
    private String NationalId;

    @Column(name="FieldId")
    private int FieldId;

    @Column(name="PhoneNumber")
    private String PhoneNumber;

    @Column(name="CreatedDate")
    private Date CreatedDate;

    @Column(name="Email")
    private String Email;

    public Patient() {
    }

    public Patient(int id, String name, String surname, String nationalId, int fieldId, String phoneNumber, Date createdDate, String email) {
        Id = id;
        Name = name;
        Surname = surname;
        NationalId = nationalId;
        FieldId = fieldId;
        PhoneNumber = phoneNumber;
        CreatedDate = createdDate;
        Email = email;
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
