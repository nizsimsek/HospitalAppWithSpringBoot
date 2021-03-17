package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IPatientService;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.PatientDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Patient;

import java.util.List;

public class PatientManager implements IPatientService {
    private final PatientDal _patientDal;

    public PatientManager(PatientDal patientDal) {
        this._patientDal = patientDal;
    }

    @Override
    public List<Patient> GetAll() {
        return _patientDal.GetAll();
    }

    @Override
    public void Add(Patient patient) {
        _patientDal.Add(patient);
    }

    @Override
    public void Update(Patient patient) {
        _patientDal.Update(patient);
    }

    @Override
    public void Delete(Patient patient) {
        _patientDal.Delete(patient);
    }

    @Override
    public Patient GetById(int id) {
        return _patientDal.GetById(id);
    }
}
