package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IUserService;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessDataResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessResult;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate.UserDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserManager implements IUserService {

    private final UserDal _userDal;

    @Autowired
    public UserManager(UserDal userDal) {
        _userDal = userDal;
    }

    @Override
    @Transactional
    public IDataResult<List<User>> GetAll() {
        return new SuccessDataResult<>(_userDal.GetAll());
    }

    @Override
    @Transactional
    public IResult Add(User user) {
        _userDal.Add(user);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult Update(User user) {
        _userDal.Update(user);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult DeleteById(int id) {
        _userDal.DeleteById(id);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IDataResult<User> GetById(int id) {
        return new SuccessDataResult<>(_userDal.GetById(id));
    }
}
