package com.nizdeniz.HospitalApp.Business.Abstract;

import com.nizdeniz.HospitalApp.Entities.Concrete.User;

import java.util.List;

public interface IUserService {
    List<User> GetAll();

    void Add(User user);

    void Update(User user);

    void Delete(User user);

    User GetById(int id);
}
