package com.nizdeniz.HospitalApp.Core.DataAccess;

import java.util.List;

public interface IEntityBaseRepository<T> {
    List<T> GetAll();

    void Add(T entity);

    void Update(T entity);

    void Delete(T entity);

    T GetById(int id);
}
