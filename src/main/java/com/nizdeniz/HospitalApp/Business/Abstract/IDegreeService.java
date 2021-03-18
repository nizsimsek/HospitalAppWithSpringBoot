package com.nizdeniz.HospitalApp.Business.Abstract;

import com.nizdeniz.HospitalApp.Entities.Concrete.Degree;

import java.util.List;

public interface IDegreeService {
    List<Degree> GetAll();

    void Add(Degree degree);

    void Update(Degree degree);

    void Delete(Degree degree);

    Degree GetById(int id);
}
