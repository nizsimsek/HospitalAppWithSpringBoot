package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IPatientService;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate.PatientDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientManager implements IPatientService {

    private final PatientDal _patientDal;

    @Autowired
    public PatientManager(PatientDal patientDal) {
        this._patientDal = patientDal;
    }

    @Override
    @Transactional
    public List<Patient> GetAll() {
        return _patientDal.GetAll();
    }

    @Override
    @Transactional
    public void Add(Patient patient) {
        _patientDal.Add(patient);
    }

    @Override
    @Transactional
    public void Update(Patient patient) {
        _patientDal.Update(patient);
    }

    @Override
    @Transactional
    public void Delete(Patient patient) {
        _patientDal.Delete(patient);
    }

    @Override
    @Transactional
    public Patient GetById(int id) {
        return _patientDal.GetById(id);
    }
}
