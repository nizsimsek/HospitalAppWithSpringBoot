package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IFieldService;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessDataResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessResult;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate.FieldDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FieldManager implements IFieldService {

    private final FieldDal _fieldDal;

    @Autowired
    public FieldManager(FieldDal fieldDal) {
        _fieldDal = fieldDal;
    }


    @Override
    @Transactional
    public IDataResult<List<Field>> GetAll() {
        return new SuccessDataResult<>(_fieldDal.GetAll());
    }

    @Override
    @Transactional
    public IResult Add(Field field) {
        _fieldDal.Add(field);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult Update(Field field) {
        _fieldDal.Update(field);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult Delete(Field field) {
        _fieldDal.Delete(field);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IDataResult<Field> GetById(int id) {
        return new SuccessDataResult<>(_fieldDal.GetById(id));
    }
}
