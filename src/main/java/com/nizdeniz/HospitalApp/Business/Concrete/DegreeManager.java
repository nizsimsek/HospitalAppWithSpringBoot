package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IDegreeService;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.DegreeDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Degree;

import java.util.List;

public class DegreeManager implements IDegreeService {
    private final DegreeDal _degreeDal;

    public DegreeManager(DegreeDal degreeDal) {
        this._degreeDal = degreeDal;
    }

    @Override
    public List<Degree> GetAll() {
        return _degreeDal.GetAll();
    }

    @Override
    public void Add(Degree degree) {
        _degreeDal.Add(degree);
    }

    @Override
    public void Update(Degree degree) {
        _degreeDal.Update(degree);
    }

    @Override
    public void Delete(Degree degree) {
        _degreeDal.Delete(degree);
    }

    @Override
    public Degree GetById(int id) {
        return _degreeDal.GetById(id);
    }
}
