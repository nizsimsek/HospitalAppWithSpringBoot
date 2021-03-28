package com.nizdeniz.HospitalApp.Business.Abstract;

import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.Degree;

import java.util.List;

public interface IDegreeService {
    IDataResult<List<Degree>> GetAll();

    IResult Add(Degree degree);

    IResult Update(Degree degree);

    IResult DeleteById(int id);

    IDataResult<Degree> GetById(int id);
}
