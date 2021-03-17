package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IUserService;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.UserDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.User;

import java.util.List;

public class UserManager implements IUserService {
    private final UserDal _userDal;

    public UserManager(UserDal userDal) {
        this._userDal = userDal;
    }

    @Override
    public List<User> GetAll() {
        return _userDal.GetAll();
    }

    @Override
    public void Add(User user) {
        _userDal.Add(user);
    }

    @Override
    public void Update(User user) {
        _userDal.Update(user);
    }

    @Override
    public void Delete(User user) {
        _userDal.Delete(user);
    }

    @Override
    public User GetById(int id) {
        return _userDal.GetById(id);
    }
}
