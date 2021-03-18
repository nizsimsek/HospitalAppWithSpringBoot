package com.nizdeniz.HospitalApp.Business.Abstract;

import com.nizdeniz.HospitalApp.Entities.Concrete.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> GetAll();

    void Add(Patient patient);

    void Update(Patient patient);

    void Delete(Patient patient);

    Patient GetById(int id);
}
