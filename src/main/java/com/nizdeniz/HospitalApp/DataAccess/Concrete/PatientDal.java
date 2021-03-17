package com.nizdeniz.HospitalApp.DataAccess.Concrete;

import com.nizdeniz.HospitalApp.DataAccess.Abstract.IPatientDal;
import com.nizdeniz.HospitalApp.Entities.Abstract.IEntity;
import com.nizdeniz.HospitalApp.Entities.Concrete.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDal implements IPatientDal {
    private IEntity _patientDal;
    private Connection _connection;

    public PatientDal(IEntity _patientDal) {
        try {
            _connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb");
            System.out.println("Veritabanı bağlantısı başarılı");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this._patientDal = _patientDal;
    }

    @Override
    public List<Patient> GetAll() {
        List<Patient> patients = new ArrayList<>();
        try {
            PreparedStatement ps = _connection.prepareStatement("SELECT * FROM Patient");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("Id"));
                patient.setName(rs.getString("Name"));
                patient.setSurname(rs.getString("Surname"));
                patient.setNationalId(rs.getString("NationalId"));
                patient.setFieldId(rs.getInt("FieldId"));
                patient.setPhoneNumber(rs.getString("PhoneNumber"));
                patient.setCreatedDate(rs.getDate("CreatedDate"));
                patient.setEmail(rs.getString("Email"));
                patients.add(patient);
            }
            return patients;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void Add(Patient patient) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("INSERT INTO Patient(Name, Surname, NationalId," +
                    " FieldId, PhoneNumber, CreatedDate, Email) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getSurname());
            ps.setString(3, patient.getNationalId());
            ps.setInt(4, patient.getFieldId());
            ps.setString(5, patient.getPhoneNumber());
            ps.setDate(6, patient.getCreatedDate());
            ps.setString(7, patient.getEmail());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Update(Patient patient) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("UPDATE Patient SET Name = ?, Surname = ?, NationalId = ?," +
                    " FieldId = ?, PhoneNumber = ?, CreatedDate = ?, Email= ? WHERE Id = ?");
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getSurname());
            ps.setString(3, patient.getNationalId());
            ps.setInt(4, patient.getFieldId());
            ps.setString(5, patient.getPhoneNumber());
            ps.setDate(6, patient.getCreatedDate());
            ps.setString(7, patient.getEmail());
            ps.setInt(8, patient.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Delete(Patient patient) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("DELETE FROM Patient WHERE Id = ?");
            ps.setInt(1, patient.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Patient GetById(int id) {
        PreparedStatement ps;
        try {
            ps = _connection.prepareStatement("SELECT * FROM Patient WHERE Id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            Patient patient = new Patient();
            patient.setId(rs.getInt("Id"));
            patient.setName(rs.getString("Name"));
            patient.setSurname(rs.getString("Surname"));
            patient.setNationalId(rs.getString("NationalId"));
            patient.setFieldId(rs.getInt("FieldId"));
            patient.setPhoneNumber(rs.getString("PhoneNumber"));
            patient.setCreatedDate(rs.getDate("CreatedDate"));
            patient.setEmail(rs.getString("Email"));
            return patient;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
