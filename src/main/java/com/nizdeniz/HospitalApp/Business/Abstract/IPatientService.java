package com.nizdeniz.HospitalApp.Business.Abstract;

import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.Patient;

import java.util.List;

public interface IPatientService {
    IDataResult<List<Patient>> GetAll();

    IResult Add(Patient patient);

    IResult Update(Patient patient);

    IResult DeleteById(int id);

    IDataResult<Patient> GetById(int id);
}
