package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IEmployeeService;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessDataResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessResult;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate.EmployeeDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeManager implements IEmployeeService {

    private final EmployeeDal _employeeDal;

    @Autowired
    public EmployeeManager(EmployeeDal _employeeDal) {
        this._employeeDal = _employeeDal;
    }

    @Override
    @Transactional
    public IDataResult<List<Employee>> GetAll() {
        return new SuccessDataResult<>(_employeeDal.GetAll());
    }

    @Override
    @Transactional
    public IResult Add(Employee employee) {
        _employeeDal.Add(employee);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult Update(Employee employee) {
        _employeeDal.Update(employee);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult Delete(Employee employee) {
        _employeeDal.Delete(employee);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IDataResult<Employee> GetById(int id) {
        return new SuccessDataResult<>(_employeeDal.GetById(id));
    }
}
