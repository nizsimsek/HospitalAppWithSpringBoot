package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IUserService;
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
        this._userDal = userDal;
    }

    @Override
    @Transactional
    public List<User> GetAll() {
        return _userDal.GetAll();
    }

    @Override
    @Transactional
    public void Add(User user) {
        _userDal.Add(user);
    }

    @Override
    @Transactional
    public void Update(User user) {
        _userDal.Update(user);
    }

    @Override
    @Transactional
    public void Delete(User user) {
        _userDal.Delete(user);
    }

    @Override
    @Transactional
    public User GetById(int id) {
        return _userDal.GetById(id);
    }
}
