package com.nizdeniz.HospitalApp.Business.Abstract;

import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.Employee;

import java.util.List;

public interface IEmployeeService {
    IDataResult<List<Employee>> GetAll();

    IResult Add(Employee employee);

    IResult Update(Employee employee);

    IResult DeleteById(int id);

    IDataResult<Employee> GetById(int id);
}
