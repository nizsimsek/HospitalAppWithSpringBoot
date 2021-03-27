package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IEmployeeStatusService;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessDataResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessResult;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate.EmployeeStatusDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeStatusManager implements IEmployeeStatusService {

    private final EmployeeStatusDal _employeeStatusDal;

    @Autowired
    public EmployeeStatusManager(EmployeeStatusDal _employeeStatusDal) {
        this._employeeStatusDal = _employeeStatusDal;
    }


    @Override
    @Transactional
    public IDataResult<List<EmployeeStatus>> GetAll() {
        return new SuccessDataResult<>(_employeeStatusDal.GetAll());
    }

    @Override
    @Transactional
    public IResult Add(EmployeeStatus employeeStatus) {
        _employeeStatusDal.Add(employeeStatus);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult Update(EmployeeStatus employeeStatus) {
        _employeeStatusDal.Update(employeeStatus);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult Delete(EmployeeStatus employeeStatus) {
        _employeeStatusDal.Delete(employeeStatus);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IDataResult<EmployeeStatus> GetById(int id) {
        return new SuccessDataResult<>(_employeeStatusDal.GetById(id));
    }
}
