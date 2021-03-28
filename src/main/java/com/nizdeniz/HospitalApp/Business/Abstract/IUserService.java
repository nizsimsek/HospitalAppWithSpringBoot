package com.nizdeniz.HospitalApp.Business.Abstract;

import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.User;

import java.util.List;

public interface IUserService {
    IDataResult<List<User>> GetAll();

    IResult Add(User user);

    IResult Update(User user);

    IResult DeleteById(int id);

    IDataResult<User> GetById(int id);
}
