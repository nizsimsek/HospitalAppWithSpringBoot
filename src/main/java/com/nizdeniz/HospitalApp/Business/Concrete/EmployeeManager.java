package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IEmployeeService;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessDataResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessResult;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.EmployeeDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Employee;

import java.util.List;

public class EmployeeManager implements IEmployeeService {

    private final EmployeeDal _employeeDal;

    public EmployeeManager(EmployeeDal _employeeDal) {
        this._employeeDal = _employeeDal;
    }

    @Override
    public IDataResult<List<Employee>> GetAll() {
        return new SuccessDataResult<>(_employeeDal.GetAll());
    }

    @Override
    public IResult Add(Employee employee) {
        _employeeDal.Add(employee);
        return new SuccessResult();
    }

    @Override
    public IResult Update(Employee employee) {
        _employeeDal.Update(employee);
        return new SuccessResult();
    }

    @Override
    public IResult Delete(Employee employee) {
        _employeeDal.Delete(employee);
        return new SuccessResult();
    }

    @Override
    public IDataResult<Employee> GetById(int id) {
        return new SuccessDataResult<>(_employeeDal.GetById(id));
    }
}
