package com.nizdeniz.HospitalApp.Business.Concrete;

import com.nizdeniz.HospitalApp.Business.Abstract.IDegreeService;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Core.Results.IResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessDataResult;
import com.nizdeniz.HospitalApp.Core.Results.SuccessResult;
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
        _degreeDal = degreeDal;
    }

    @Override
    @Transactional
    public IDataResult<List<Degree>> GetAll() {
        return new SuccessDataResult<>(_degreeDal.GetAll());
    }

    @Override
    @Transactional
    public IResult Add(Degree degree) {
        _degreeDal.Add(degree);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult Update(Degree degree) {
        _degreeDal.Update(degree);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IResult DeleteById(int id) {
        _degreeDal.DeleteById(id);
        return new SuccessResult();
    }

    @Override
    @Transactional
    public IDataResult<Degree> GetById(int id) {
        return new SuccessDataResult<>(_degreeDal.GetById(id));
    }
}
