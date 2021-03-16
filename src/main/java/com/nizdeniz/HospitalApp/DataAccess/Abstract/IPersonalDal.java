package com.nizdeniz.HospitalApp.DataAccess.Abstract;

import com.nizdeniz.HospitalApp.Entities.Concrete.Personal;

import java.util.List;

public interface IPersonalDal {
    List<Personal> GetAll();
    void Add(Personal personal);
    void Update(Personal personal);
    void Delete(Personal personal);
    Personal GetById(int id);
}
