package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IEmployeeStatusService;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessDataResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessResult;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.EmployeeStatusDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.EmployeeStatus;

import java.util.List;

public class EmployeeStatusManager implements IEmployeeStatusService {

    private final EmployeeStatusDal _employeeStatusDal;

    public EmployeeStatusManager(EmployeeStatusDal _employeeStatusDal) {
        this._employeeStatusDal = _employeeStatusDal;
    }


    @Override
    public IDataResult<List<EmployeeStatus>> GetAll() {
        return new SuccessDataResult<>(_employeeStatusDal.GetAll());
    }

    @Override
    public IResult Add(EmployeeStatus employeeStatus) {
        _employeeStatusDal.Add(employeeStatus);
        return new SuccessResult();
    }

    @Override
    public IResult Update(EmployeeStatus employeeStatus) {
        _employeeStatusDal.Update(employeeStatus);
        return new SuccessResult();
    }

    @Override
    public IResult Delete(EmployeeStatus employeeStatus) {
        _employeeStatusDal.Delete(employeeStatus);
        return new SuccessResult();
    }

    @Override
    public IDataResult<EmployeeStatus> GetById(int id) {
        return new SuccessDataResult<>(_employeeStatusDal.GetById(id));
    }
}
