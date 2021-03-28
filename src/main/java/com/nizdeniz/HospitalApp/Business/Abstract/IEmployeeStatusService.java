package com.nizdeniz.HospitalApp.Business.Abstract;

import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.EmployeeStatus;

import java.util.List;

public interface IEmployeeStatusService {
    IDataResult<List<EmployeeStatus>> GetAll();

    IResult Add(EmployeeStatus employeeStatus);

    IResult Update(EmployeeStatus employeeStatus);

    IResult DeleteById(int id);

    IDataResult<EmployeeStatus> GetById(int id);
}
