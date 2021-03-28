package com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate;

import com.nizdeniz.HospitalApp.DataAccess.Abstract.IEmployeeDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDal implements IEmployeeDal {

    private final EntityManager _entityManager;

    @Autowired
    public EmployeeDal(EntityManager _entityManager) {
        this._entityManager = _entityManager;
    }

    @Override
    @Transactional
    public List<Employee> GetAll() {
        Session session = _entityManager.unwrap(Session.class);
        return session.createQuery("FROM Employee", Employee.class).getResultList();
    }

    @Override
    @Transactional
    public void Add(Employee entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void Update(Employee entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void DeleteById(int id) {
        Session session = _entityManager.unwrap(Session.class);
        Employee entityToDelete = session.get(Employee.class, id);
        session.delete(entityToDelete);
    }

    @Override
    @Transactional
    public Employee GetById(int id) {
        Session session = _entityManager.unwrap(Session.class);
        return session.get(Employee.class, id);
    }
}
