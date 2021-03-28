package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IPatientService;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessDataResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessResult;
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
        _patientDal = patientDal;
    }

    @Override
    @Transactional
    public IDataResult<List<Patient>> GetAll() {
        return new SuccessDataResult<>(_patientDal.GetAll());
    }

    @Override
    @Transactional
    public IResult Add(Patient patient) {
        _patientDal.Add(patient);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult Update(Patient patient) {
        _patientDal.Update(patient);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult DeleteById(int id) {
        _patientDal.DeleteById(id);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IDataResult<Patient> GetById(int id) {
        return new SuccessDataResult<>(_patientDal.GetById(id));
    }
}
