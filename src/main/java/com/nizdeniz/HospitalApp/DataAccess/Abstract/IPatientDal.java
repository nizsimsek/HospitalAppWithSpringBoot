package com.nizdeniz.HospitalApp.DataAccess.Abstract;

import com.nizdeniz.HospitalApp.Entities.Concrete.Patient;

import java.util.List;

public interface IPatientDal {
    List<Patient> GetAll();

    void Add(Patient patient);

    void Update(Patient patient);

    void Delete(Patient patient);

    Patient GetById(int id);
}
