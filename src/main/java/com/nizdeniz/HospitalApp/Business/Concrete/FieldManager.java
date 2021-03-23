package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IFieldService;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessDataResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessResult;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.FieldDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Field;

import java.util.List;

public class FieldManager implements IFieldService {
    private final FieldDal _fieldDal;

    public FieldManager(FieldDal fieldDal) {
        _fieldDal = fieldDal;
    }


    @Override
    public IDataResult<List<Field>> GetAll() {
        return new SuccessDataResult<>(_fieldDal.GetAll());
    }

    @Override
    public IResult Add(Field field) {
        _fieldDal.Add(field);
        return new SuccessResult();
    }

    @Override
    public IResult Update(Field field) {
        _fieldDal.Update(field);
        return new SuccessResult();
    }

    @Override
    public IResult Delete(Field field) {
        _fieldDal.Delete(field);
        return new SuccessResult();
    }

    @Override
    public IDataResult<Field> GetById(int id) {
        return new SuccessDataResult<>(_fieldDal.GetById(id));
    }
}
