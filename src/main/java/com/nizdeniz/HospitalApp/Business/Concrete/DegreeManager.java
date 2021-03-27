package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IDegreeService;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate.DegreeDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DegreeManager implements IDegreeService {

    private final DegreeDal _degreeDal;

    @Autowired
    public DegreeManager(DegreeDal degreeDal) {
        this._degreeDal = degreeDal;
    }

    @Override
    @Transactional
    public List<Degree> GetAll() {
        return _degreeDal.GetAll();
    }

    @Override
    @Transactional
    public void Add(Degree degree) {
        _degreeDal.Add(degree);
    }

    @Override
    @Transactional
    public void Update(Degree degree) {
        _degreeDal.Update(degree);
    }

    @Override
    @Transactional
    public void Delete(Degree degree) {
        _degreeDal.Delete(degree);
    }

    @Override
    @Transactional
    public Degree GetById(int id) {
        return _degreeDal.GetById(id);
    }
}
