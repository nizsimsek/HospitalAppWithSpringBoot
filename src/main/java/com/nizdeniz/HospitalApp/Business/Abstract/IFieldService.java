package com.nizdeniz.HospitalApp.Business.Abstract;

import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.Field;

import java.util.List;

public interface IFieldService {
    IDataResult<List<Field>> GetAll();

    IResult Add(Field field);

    IResult Update(Field field);

    IResult DeleteById(int id);

    IDataResult<Field> GetById(int id);
}
