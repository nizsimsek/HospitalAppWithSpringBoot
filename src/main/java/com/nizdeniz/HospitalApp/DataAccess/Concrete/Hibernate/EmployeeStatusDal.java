package com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate;

import com.nizdeniz.HospitalApp.DataAccess.Abstract.IEmployeeStatusDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.EmployeeStatus;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeStatusDal implements IEmployeeStatusDal {

    private final EntityManager _entityManager;

    @Autowired
    public EmployeeStatusDal(EntityManager _entityManager) {
        this._entityManager = _entityManager;
    }

    @Override
    @Transactional
    public List<EmployeeStatus> GetAll() {
        Session session = _entityManager.unwrap(Session.class);
        return _entityManager.createQuery("FROM Employee_Status", EmployeeStatus.class).getResultList();
    }

    @Override
    @Transactional
    public void Add(EmployeeStatus entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void Update(EmployeeStatus entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void Delete(EmployeeStatus entity) {
        Session session = _entityManager.unwrap(Session.class);
        EmployeeStatus entityToDelete = session.get(EmployeeStatus.class, entity.getId());
        session.delete(entityToDelete);
    }

    @Override
    @Transactional
    public EmployeeStatus GetById(int id) {
        Session session = _entityManager.unwrap(Session.class);
        return session.get(EmployeeStatus.class, id);
    }
}
