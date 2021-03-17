package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IPersonalService;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.PersonalDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Personal;

import java.util.List;

public class PersonalManager implements IPersonalService {

    private final PersonalDal _personalDal;

    public PersonalManager(PersonalDal personalDal) {
        this._personalDal = personalDal;
    }

    @Override
    public List<Personal> GetAll() {
        return _personalDal.GetAll();
    }

    @Override
    public void Add(Personal personal) {
        _personalDal.Add(personal);
    }

    @Override
    public void Update(Personal personal) {
        _personalDal.Update(personal);
    }

    @Override
    public void Delete(Personal personal) {
        _personalDal.Delete(personal);
    }

    @Override
    public Personal GetById(int id) {
        return _personalDal.GetById(id);
    }
}
